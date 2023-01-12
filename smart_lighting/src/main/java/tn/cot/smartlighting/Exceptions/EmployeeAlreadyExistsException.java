package tn.cot.smartlighting.Exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException {
    String message;
    public EmployeeAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
