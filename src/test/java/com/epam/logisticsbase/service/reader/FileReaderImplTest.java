package com.epam.logisticsbase.service.reader;

import org.junit.Test;
public class FileReaderImplTest {

    @Test
    public void read() {
        FileReaderImpl fileReader=FileReaderImpl.getInstance();
       fileReader.read("src/test/resources/Cars.xml");

    }
    @Test
    public void read2() {
        FileReaderImpl fileReader=FileReaderImpl.getInstance();
        fileReader.read("src/test/resources/Cars3.xml");

    }
    @Test
    public void read3() {
        FileReaderImpl fileReader=FileReaderImpl.getInstance();
        fileReader.read("src/test/resources/Cars4.xml");

    }

}