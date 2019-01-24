package java.com.epam.logisticsbase.service.reader;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileReaderImplTest {

    @Test
    public void read() {
        FileReaderImpl fileReader=new FileReaderImpl();
        fileReader.read("resources/Cars.xml");
    }

    @Test
    public void read2() {
        FileReaderImpl fileReader=new FileReaderImpl();
        fileReader.read("resources/Cars2.xml");
    }

    @Test
    public void read3() {
        FileReaderImpl fileReader=new FileReaderImpl();
        fileReader.read("");
    }

    @Test
    public void read4() {
        FileReaderImpl fileReader=new FileReaderImpl();
        fileReader.read("absd");
    }

}