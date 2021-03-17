package eu.senla.task10.api.exceptions;

public class NoSuchIndexException extends Exception{
    @Override
    public String getMessage() {
        return "No such index";
    }
}
