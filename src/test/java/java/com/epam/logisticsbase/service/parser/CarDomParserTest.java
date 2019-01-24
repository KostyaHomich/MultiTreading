package java.com.epam.logisticsbase.service.parser;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class CarDomParserTest {

    @Test
    public void parse() {
        CarDomParser carDomParser=new CarDomParser();
        carDomParser.parse(new File("resources/Cars.xml"));
    }

    @Test
    public void parse2() {
        CarDomParser carDomParser=new CarDomParser();
        carDomParser.parse(new File("resources/Cars2.xml"));
    }

    @Test
    public void parse3() {
        CarDomParser carDomParser=new CarDomParser();
        carDomParser.parse(new File(""));
    }

    @Test
    public void parse4() {
        CarDomParser carDomParser=new CarDomParser();
        carDomParser.parse(new File("absd"));
    }
}