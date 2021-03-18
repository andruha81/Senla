package eu.senla.task10.api.exceptions;

public class AgeOutOfBoundException extends Exception {
    @Override
    public String getMessage() {
        return "Age out of bounds from 0 to 20";
    }
}
