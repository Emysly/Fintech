package com.emysilva.fintech.exception;

public class AuthenticationException extends BaseException {
    public AuthenticationException() {
        setStatus(403);
        setErrorCode("UNAUTHORIZED");
    }

    public AuthenticationException(String message) {
        super(message);
        setStatus(403);
        setErrorCode("UNAUTHORIZED");
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
        setStatus(403);
        setErrorCode("UNAUTHORIZED");
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
        setStatus(403);
        setErrorCode("UNAUTHORIZED");
    }
}
