package com.epam.logisticsbase.controller;

import com.epam.logisticsbase.controller.LogisticBaseController;
import org.junit.Test;


public class LogisticBaseControllerTest {

    @Test
    public void readFileAndStartThreads() {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("src/test/resources/Cars.xml","src/main/resources/Cars.xsd",3);

    }

    @Test
    public void readFileAndStartThreads2() {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("src/test/resources/Cars3.xml","src/main/resources/Cars.xsd",3);

    }
    @Test
    public void readFileAndStartThreads3() {
        LogisticBaseController logisticBaseController=LogisticBaseController.getInstance();
        logisticBaseController.readFileAndStartThreads("src/test/resources/Cars4.xml","src/main/resources/Cars.xsd",3);

    }
}