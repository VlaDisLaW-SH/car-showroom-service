package com.carshop.exception;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class CustomValidationException extends RuntimeException {
    private final BindingResult bindingResult;

    public CustomValidationException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public List<String> getErrors() {
        List<String> errors = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        });
        return errors;
    }
}
