package eu.senla.task10.api.exceptions;

public class NullNameException extends Exception{
    @Override
    public String getMessage() {
        return "Name is null";
    }
}
