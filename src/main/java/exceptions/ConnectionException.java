package exceptions;

/**
 * Exception class for common SQL connection error not caught by other exeptions
 */
public class ConnectionException extends DAOException {

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(Throwable cause) {
        super(cause);
    }

}


