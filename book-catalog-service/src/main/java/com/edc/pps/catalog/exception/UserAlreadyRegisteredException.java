package com.edc.pps.catalog.exception;

public class UserAlreadyRegisteredException extends Throwable {
    public UserAlreadyRegisteredException(String message) {
        super(message);
    }
}
