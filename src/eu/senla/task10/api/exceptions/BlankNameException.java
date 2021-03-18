package eu.senla.task10.api.exceptions;

public class BlankNameException extends Exception{
    @Override
    public String getMessage() {
        return "Name is blank";
    }
}
