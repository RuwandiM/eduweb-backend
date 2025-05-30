package eduweb.eduweb_backend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(NotFoundException studentNotFoundException) {

        Exception studentException = new Exception(
                studentNotFoundException.getMessage(),
                studentNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(studentException, HttpStatus.NOT_FOUND);

    }
}

