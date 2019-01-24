package java.com.epam.logisticsbase.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogisticBaseControllerTest {

    @Test
    public void readFileAndStartThreads() {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("resources/Cars.xml","resources/Cars.xsd",3);
    }

    @Test
    public void readFileAndStartThreads2() {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("resources/Cars2.xml","",3);
    }

    @Test
    public void readFileAndStartThreads3() {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("","resources/Cars.xsd",2);
    }
    @Test
    public void readFileAndStartThreads4() {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("","",0);
    }
}