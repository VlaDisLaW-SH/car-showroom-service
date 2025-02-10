package com.carshop.exception;

public class VehicleNotAvailableForOrderException extends RuntimeException{
    public VehicleNotAvailableForOrderException(String message) {
        super(message);
    }
}
