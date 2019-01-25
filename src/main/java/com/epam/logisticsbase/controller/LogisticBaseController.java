package com.epam.logisticsbase.controller;

import com.epam.logisticsbase.entity.Car;
import com.epam.logisticsbase.entity.LogisticBase;
import com.epam.logisticsbase.entity.Terminal;
import com.epam.logisticsbase.exception.IncorrectInputException;
import com.epam.logisticsbase.service.parser.CarDomParser;
import com.epam.logisticsbase.service.parser.XmlParser;
import com.epam.logisticsbase.service.reader.FileReader;
import com.epam.logisticsbase.service.reader.FileReaderImpl;
import com.epam.logisticsbase.service.validator.Validator;
import com.epam.logisticsbase.service.validator.XmlValidatorImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;


public class LogisticBaseController {

    private static Logger logger = LogManager.getLogger(LogisticBaseController.class);
    private static LogisticBaseController instance = new LogisticBaseController();

    private LogisticBaseController() {
    }

    public static LogisticBaseController getInstance() {
        if (instance == null) {
            instance = new LogisticBaseController();

        }
        return instance;
    }

    public void readFileAndStartThreads(String pathXml, String pathXsd, int amountTerminal) {
        if (pathXml == null || pathXml.isEmpty() || pathXsd == null || pathXsd.isEmpty() || amountTerminal <= 1) {
            logger.error("Incorrect string parameters");
            throw new IncorrectInputException("Incorrect string parameters");
        }

        FileReader fileReader = FileReaderImpl.getInstance();
        Validator validator = new XmlValidatorImpl();

        if (!validator.isValid(fileReader.read(pathXml), fileReader.read(pathXsd))) {
            logger.error("Invalid file");
            throw new IncorrectInputException("Invalid file");
        }
        LogisticBase logisticBase = LogisticBase.getInstance();
        XmlParser xmlParser = new CarDomParser();
        List<Car> carList = xmlParser.parse(fileReader.read(pathXml)).stream().sorted(Comparator.comparing(Car::getPriority).reversed()).collect(Collectors.toList());
        Semaphore semaphore = new Semaphore(amountTerminal);

        logger.info("Threads start");
        setSemaphores(carList, semaphore);
        setTerminals(amountTerminal, logisticBase, carList);
        startThreads(carList);

    }

    private void setSemaphores(List<Car> carList, Semaphore semaphore) {
        for (Car car : carList) {
            car.setSemaphore(semaphore);
        }
    }

    private void setTerminals(int amountTerminal, LogisticBase logisticBase, List<Car> carList) {
        for (int i = amountTerminal; i > 0; i--) {
            Terminal terminal = new Terminal(i);
            logisticBase.addTerminal(terminal);
            for (Car car : carList) {
                if (car.getTerminal() == i) {
                    car.setTerminalObj(terminal);
                }
            }
        }
    }

    private void startThreads(List<Car> carList) {
        for (Car aCarList : carList) {
            Thread thread = new Thread(aCarList);
            thread.setName(aCarList.getName());
            thread.setPriority(aCarList.getPriority());
            thread.start();
        }
    }
}
