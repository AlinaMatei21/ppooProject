package restaurant.exceptions;

public class InvalidFormatException extends Exception {
    private String message;

    public InvalidFormatException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
