package com.epam.logisticsbase.service.validator;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import com.epam.logisticsbase.exception.IncorrectInputException;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javax.xml.validation.Validator;

public class XmlValidatorImpl implements com.epam.logisticsbase.service.validator.Validator {

    private static Logger logger = LogManager.getLogger(XmlValidatorImpl.class);

    public XmlValidatorImpl()
    {}

    @Override
    public boolean isValid(File xml, File xsd) {
        try {
            xml = Optional.of(xml).orElseThrow(() -> new IncorrectInputException("Incorrect xml file"));
            xsd = Optional.of(xsd).orElseThrow(() -> new IncorrectInputException("Incorrect xsd file"));
            SchemaFactory factory = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        } catch (SAXException | IOException e) {
            logger.error("Invalid file, cause: " + e.getMessage());
            return false;
        }
    }

}
