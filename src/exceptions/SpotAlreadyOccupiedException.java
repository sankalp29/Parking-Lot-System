package exceptions;

public class SpotAlreadyOccupiedException extends RuntimeException {

    public SpotAlreadyOccupiedException(String message) {
        super(message);
    }
}
