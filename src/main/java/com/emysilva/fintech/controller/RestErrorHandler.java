package com.emysilva.fintech.controller;

import com.emysilva.fintech.exception.AuthenticationException;
import com.emysilva.fintech.exception.ErrorCodes;
import com.emysilva.fintech.exception.ResourceNotFoundException;
import com.emysilva.fintech.exception.UserExistsException;
import com.emysilva.fintech.http.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        System.out.println(ex.getBindingResult().getFieldErrors());
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->  errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setSuccess(false);
        errorResponse.setStatus(status.value());
        errorResponse.setErrorCode(ErrorCodes.INVALID_FIELD);
        errorResponse.setErrors(errors);
        errorResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorResponse, headers, status);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(UserExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleUserExistsException(UserExistsException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorResponse handleUserExistsException(AuthenticationException exception) {
        return new ErrorResponse(exception);
    }
}
