package com.emysilva.fintech.exception;

public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException() {
        setErrorCode("NOT_FOUND");
        setStatus(404);
    }

    public ResourceNotFoundException(String message) {
        super(message);
        setErrorCode("NOT_FOUND");
        setStatus(404);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        setErrorCode("NOT_FOUND");
        setStatus(404);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
        setErrorCode("NOT_FOUND");
        setStatus(404);
    }

}
