package restaurant.exceptions;

public class CommandFailedException extends Exception{
    private String message;

    public CommandFailedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
