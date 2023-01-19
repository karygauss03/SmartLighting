package tn.cot.smartlighting.Exceptions;

public class EmployeeForbiddenException extends RuntimeException{
    String message;
    public EmployeeForbiddenException(String message) {
        super(message);
        this.message = message;
    }
}
