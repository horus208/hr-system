package com.example.auth.exceptions;


import lombok.Data;

@Data
public class ErrorDetails {
    private String title;
    private int status;
    private Object detail;
    private long timeStamp;



}

