package ru.rusguardian.exception;

public class CalculatePriceException extends RuntimeException {
    public CalculatePriceException(String message) {
        super(message);
    }
}
