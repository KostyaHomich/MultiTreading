package java.com.epam.logisticsbase.service.validator;

import org.junit.Test;

import static org.junit.Assert.*;

public class XmlValidatorImplTest {

    @Test
    public void isValid() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        xmlValidator.isValid("resources/Cars.xml","resources/Cars.xsd");

    }

    @Test
    public void isValid2() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        xmlValidator.isValid("resources/Cars.xml","");

    }

    @Test
    public void isValid3() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        xmlValidator.isValid("","resources/Cars.xsd");

    }

    @Test
    public void isValid4() {
        XmlValidatorImpl xmlValidator=new XmlValidatorImpl();
        xmlValidator.isValid("","");

    }
}