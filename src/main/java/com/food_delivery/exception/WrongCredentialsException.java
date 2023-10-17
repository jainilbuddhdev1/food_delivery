package com.food_delivery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException()
    {
        super("Invalid emailId or password !!");
    }
}