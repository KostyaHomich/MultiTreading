package com.epam.logisticsbase.service.validator;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class XmlValidatorImplTest {

    @Test
    public void isValid() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        Assert.assertEquals(xmlValidator.isValid(new File("src/test/resources/Cars.xml"),new File("src/main/resources/Cars.xsd")),true);

    }

    @Test
    public void isValid2() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        Assert.assertEquals(xmlValidator.isValid(new File("src/test/resources/Cars2.xml"),new File("src/main/resources/Cars.xsd")),false);

    }
    @Test
    public void isValid3() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        Assert.assertEquals(xmlValidator.isValid(new File("src/test/resources/Cars3.xml"),new File("src/main/resources/Cars.xsd")),true);

    }

    @Test
    public void isValid4() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        Assert.assertEquals(xmlValidator.isValid(new File("src/test/resources/Cars4.xml"),new File("src/main/resources/Cars.xsd")),true);

    }
}