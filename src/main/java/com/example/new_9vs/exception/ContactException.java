package com.example.new_9vs.exception;

import lombok.Getter;

@Getter
public class ContactException extends Exception {
    private final int statusCode;

    public ContactException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }

}
