package com.emysilva.fintech.http;

import com.emysilva.fintech.exception.BaseException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private boolean success;
    private int status;
    private String errorCode;
    private String message;
    private Map<String, String> errors;
    private LocalDateTime timestamp;

    public ErrorResponse(BaseException exception) {
        this();
        this.status = exception.getStatus();
        this.errorCode = Optional.ofNullable(exception.getErrorCode()).orElse(exception.getClass().getSimpleName());
        this.message = exception.getMessage();
    }

    public ErrorResponse() {
        this.timestamp = LocalDateTime.now();
        this.success = false;
    }

    public ErrorResponse(int status) {
        this();
        this.status = status;
    }

    public ErrorResponse(int status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
    }

    public ErrorResponse(int status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(int status, String errorCode, String message, Throwable ex) {
        this();
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
