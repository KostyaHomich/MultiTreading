package com.epam.logisticsbase.service.validator;


import java.io.File;

public interface Validator {
      boolean isValid(File pathXml, File pathXsd);
}
