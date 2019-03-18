package exceptions;

public class WrongCommandFormatException extends Exception {
    public WrongCommandFormatException() {
        super("The format for this command is incorrect.");
    }
}
