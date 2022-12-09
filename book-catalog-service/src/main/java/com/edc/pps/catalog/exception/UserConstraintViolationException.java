package com.edc.pps.catalog.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

public class UserConstraintViolationException extends RuntimeException {
    public UserConstraintViolationException(String message) {
        super(message);
    }
}
