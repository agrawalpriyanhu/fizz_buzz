package com.hackathon.fizz_buzz.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
