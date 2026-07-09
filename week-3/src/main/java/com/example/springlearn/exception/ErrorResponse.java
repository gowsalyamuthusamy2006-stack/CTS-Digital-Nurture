package com.example.springlearn.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String message;
    private String details;
    private String errorCode;
    private int status;
    private LocalDateTime timestamp;

    public ErrorResponse(String message, String details, int status) {
        this.message = message;
        this.details = details;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String message, String details, String errorCode, int status) {
        this.message = message;
        this.details = details;
        this.errorCode = errorCode;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}