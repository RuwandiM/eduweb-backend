package eduweb.eduweb_backend.exception;

public class StudentNotFoundException extends RuntimeException{

    // constructors
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}