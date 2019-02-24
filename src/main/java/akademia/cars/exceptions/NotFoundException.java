package akademia.cars.exceptions;

public class NotFoundException extends Exception {
    String message = "Car not exist!";

    public NotFoundException(String message) {
        super(message);

    }
}
