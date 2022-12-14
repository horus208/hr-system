package com.example.employees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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


    @ExceptionHandler({ ResourceNotFoundException.class })

    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception)
    {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTitle("Resource Not Found");
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception)
    {

        Map<String,String> errorsTable = new HashMap<>();
        List<FieldError> errors = exception.getBindingResult().getFieldErrors();
        for(FieldError error:errors)
            errorsTable.put(error.getField(), error.getDefaultMessage());

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTitle("Arguments Not Valid");
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetails.setTimeStamp(new Date().getTime());
        errorDetails.setDetail(errorsTable);
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);


    }

}
