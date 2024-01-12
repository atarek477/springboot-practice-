package com.ahmed.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DuplicationData extends RuntimeException{
    public DuplicationData(String message) {
        super(message);
    }
}
