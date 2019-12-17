package com.epam.rudy.exception;

public class VehicleCreationException extends Exception {

    public VehicleCreationException(String message) {
        super(message);
    }

    public VehicleCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleCreationException(Throwable cause) {
        super(cause);
    }
}
