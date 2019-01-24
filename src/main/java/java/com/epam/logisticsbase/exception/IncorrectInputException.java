package java.com.epam.logisticsbase.exception;

public class IncorrectInputException extends RuntimeException {
    public IncorrectInputException() {
        super();
    }

    public IncorrectInputException(String s) {
        super(s);
    }

    public IncorrectInputException(Throwable t) {
        super(t);
    }
}
