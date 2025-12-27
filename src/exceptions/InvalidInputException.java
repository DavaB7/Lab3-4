package exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Ошибка ввода: " + super.getMessage();
    }
}
