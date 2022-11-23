package com.thing.auth.exception;

public class PasswordMisMatchException extends RuntimeException{

    public PasswordMisMatchException(){
        super();
    }

    public PasswordMisMatchException(String message){
        super(message);
    }

    public PasswordMisMatchException(String message, Throwable th){
        super(message, th);
    }

}
