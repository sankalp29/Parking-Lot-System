package exceptions;

public class NoParkingAvailableException extends RuntimeException {
    public NoParkingAvailableException(String message) {
        super(message);
    }
}
