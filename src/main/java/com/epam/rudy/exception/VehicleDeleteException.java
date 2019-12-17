package com.epam.rudy.exception;

public class VehicleDeleteException extends Exception {

    public VehicleDeleteException(String message) {
        super(message);
    }

    public VehicleDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleDeleteException(Throwable cause) {
        super(cause);
    }
}
