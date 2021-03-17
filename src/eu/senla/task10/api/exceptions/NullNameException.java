package eu.senla.task10.api.exceptions;

public class NullNameException extends RuntimeException{
    @Override
    public String getMessage() {
        return "Name null or blank";
    }
}
