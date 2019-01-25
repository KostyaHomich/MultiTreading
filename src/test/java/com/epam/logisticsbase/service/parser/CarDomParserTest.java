package com.epam.logisticsbase.service.parser;


import org.junit.Test;

import java.io.File;


public class CarDomParserTest {

    @Test
    public void parse() {
        CarDomParser carDomParser=new CarDomParser();
        carDomParser.parse(new File("src/test/resources/Cars.xml")).forEach(s-> System.out.println(s.toString()));
    }

    @Test
    public void parse2() {
        CarDomParser carDomParser=new CarDomParser();
        carDomParser.parse(new File("src/test/resources/Cars3.xml")).forEach(s-> System.out.println(s.toString()));
    }
    @Test
    public void parse3() {
        CarDomParser carDomParser=new CarDomParser();
        carDomParser.parse(new File("src/test/resources/Cars4.xml")).forEach(s-> System.out.println(s.toString()));
    }
}