package akademia.cars.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarExceptionController {

    @ExceptionHandler(value = AlreadyExistException.class)
    public ResponseEntity<ExceptionMessage> exception(AlreadyExistException e) {
        return
                new ResponseEntity<>(
                        new ExceptionMessage("Car Already exist", HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionMessage> exception(NotFoundException e) {
        return
                new ResponseEntity<> (
                        new ExceptionMessage (
                                "Car not found",
                                HttpStatus.NOT_FOUND.value()
                        ),HttpStatus.NOT_FOUND);
    }


}
