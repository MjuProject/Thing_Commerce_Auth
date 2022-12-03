package com.thing.auth.exception;

public class TokenNotValidException extends RuntimeException{
    public TokenNotValidException(){
        super();
    }

    public TokenNotValidException(String message){
        super(message);
    }

    public TokenNotValidException(String message, Throwable th){
        super(message, th);
    }
}
