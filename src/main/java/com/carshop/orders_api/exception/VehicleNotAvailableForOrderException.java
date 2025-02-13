package com.carshop.orders_api.exception;

public class VehicleNotAvailableForOrderException extends RuntimeException{
    public VehicleNotAvailableForOrderException(String message) {
        super(message);
    }
}
