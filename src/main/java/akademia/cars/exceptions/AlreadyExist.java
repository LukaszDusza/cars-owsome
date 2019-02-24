package akademia.cars.exceptions;

public class AlreadyExist extends Exception {

    String message = "Car exist!";

    public AlreadyExist(String message) {
        super(message);


    }
}
