package com.epam.logisticsbase.service.reader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.epam.logisticsbase.exception.IncorrectInputException;
import java.io.File;
import java.util.Optional;


public class FileReaderImpl implements FileReader {
    private static Logger logger = LogManager.getLogger(FileReaderImpl.class);

    private static FileReaderImpl instance = new FileReaderImpl();

    public static FileReaderImpl getInstance() {
        return instance;
    }

    private FileReaderImpl()
    {}

    public File read(String path) {
        File file = new File(Optional.of(path).orElseThrow(() -> new IncorrectInputException("Path is null pointer")));
        if (!file.exists() || !file.isFile()) {
            logger.error("File does not exist or not a file");
            throw new IncorrectInputException("File does not exist or not a file");
        }
        return file;
    }
}
