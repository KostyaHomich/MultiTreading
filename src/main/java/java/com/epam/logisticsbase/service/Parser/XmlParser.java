package java.com.epam.logisticsbase.service.parser;

import java.com.epam.logisticsbase.entity.Car;
import java.io.File;
import java.util.List;

public interface XmlParser {
    List<Car> parse(File parsedFile);
}
