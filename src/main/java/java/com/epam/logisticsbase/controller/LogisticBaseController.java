package java.com.epam.logisticsbase.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class LogisticBaseController {


    private static LogisticBaseController instance = new LogisticBaseController();

    private LogisticBaseController(){}

    public static LogisticBaseController getInstance() {
        if (instance == null) {
            instance = new LogisticBaseController();

        }
        return instance;
    }

    public void readFileAndStartThreads(String pathXml, String pathXsd, int amountTerminal) {
        throw new UnsupportedOperationException();
    }
}
