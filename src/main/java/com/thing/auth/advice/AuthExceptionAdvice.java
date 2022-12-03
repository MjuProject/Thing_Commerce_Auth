package com.thing.auth.advice;

import com.thing.auth.dto.APIResponseDTO;
import com.thing.auth.exception.AuthExceptionType;
import com.thing.auth.exception.PasswordMisMatchException;
import com.thing.auth.exception.TokenNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AuthExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO unknown(Exception e){
        log.error("unknown exception", e);
        AuthExceptionType exceptionType = AuthExceptionType.UNKNOWN;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

    @ExceptionHandler(PasswordMisMatchException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO passwordMisMatchException(){
        AuthExceptionType exceptionType = AuthExceptionType.PASSWORD_MISMATCH;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

    @ExceptionHandler(TokenNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected APIResponseDTO tokenNotValidException(){
        AuthExceptionType exceptionType = AuthExceptionType.TOKEN_NOT_VALID;
        return APIResponseDTO.fail(exceptionType.getCode(), exceptionType.getMessage());
    }

}
