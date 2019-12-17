package com.epam.rudy.exception;

public class VehicleDisplayException extends Exception {

    public VehicleDisplayException(String message) {
        super(message);
    }

    public VehicleDisplayException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleDisplayException(Throwable cause) {
        super(cause);
    }
}
