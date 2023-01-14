package tn.cot.smartlighting.Exceptions;

public class CityNotFoundException extends RuntimeException{
    String message;
    public CityNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
