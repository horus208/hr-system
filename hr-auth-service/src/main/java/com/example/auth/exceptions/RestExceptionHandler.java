package com.example.auth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler
{


    @ExceptionHandler({ AuthenticationException.class })

    public ResponseEntity<ErrorDetails> handlePasswordEmailAuthenticationException(PasswordEmailAuthenticationException exception)
    {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTitle("Authentication failed");
        errorDetails.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorDetails.setTimeStamp(new Date().getTime());
        errorDetails.setDetail(exception.getMessage());
        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
    }




    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception)
    {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTitle("Request Not Readable");
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetails.setTimeStamp(new Date().getTime());
        errorDetails.setDetail(exception.getMessage());
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);


    }



}
