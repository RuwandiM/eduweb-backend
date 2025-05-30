package eduweb.eduweb_backend.exception;

public class NotFoundException extends RuntimeException{

    // constructors
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}