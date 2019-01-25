package com.epam.logisticsbase.service.parser;

import com.epam.logisticsbase.service.constant.CarConstants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import com.epam.logisticsbase.entity.Car;
import com.epam.logisticsbase.exception.IncorrectInputException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarDomParser implements XmlParser {


    private static Logger logger = LogManager.getLogger(CarDomParser.class);

    @Override
    public List<Car> parse(File parsedFile) {
        List<Car> carList;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(parsedFile);
            carList = parseParameters(document.getDocumentElement().getElementsByTagName("Car"));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("Exception occurs while parsing:" + e.getMessage());
            throw new IncorrectInputException(e);
        }
        return carList;
    }

    private List<Car> parseParameters(NodeList carElements) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carElements.getLength(); i++) {
            Node car = carElements.item(i);
            Car carObj = new Car();
            if (car.getNodeType() != Node.TEXT_NODE) {
                for (int j = 0; j < car.getChildNodes().getLength(); j++) {
                    switch (car.getChildNodes().item(j).getNodeName()) {
                        case CarConstants.NAME:
                            carObj.setName(car.getChildNodes().item(j).getTextContent());
                            break;
                        case CarConstants.ACTION:
                            carObj.setAction(car.getChildNodes().item(j).getTextContent());
                            break;
                        case CarConstants.PRIORITY:
                            carObj.setPriority(Integer.valueOf(car.getChildNodes().item(j).getTextContent()));
                            break;
                        case CarConstants.TERMINAL:
                            carObj.setTerminal(Integer.valueOf(car.getChildNodes().item(j).getTextContent()));
                            break;
                    }
                }
                carList.add(carObj);
            }

        }
        return carList;

    }

}
