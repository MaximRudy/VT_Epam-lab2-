package com.epam.rudy.exception;

public class VehicleUpdateException extends Exception {

    public VehicleUpdateException(String message) {
        super(message);
    }

    public VehicleUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleUpdateException(Throwable cause) {
        super(cause);
    }
}
