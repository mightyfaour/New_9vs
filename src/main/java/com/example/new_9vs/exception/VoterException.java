package com.example.new_9vs.exception;

import lombok.Getter;

@Getter
public class VoterException extends RuntimeException{
    private final int statusCode;
    public VoterException(String message, int statusCode){
        super(message);
        this.statusCode = statusCode;
    }

}
