package com.emysilva.fintech.exception;

public class UserExistsException extends BaseException {
    public UserExistsException() {
        setErrorCode(ErrorCodes.USER_EXISTS);
        setStatus(400);
    }

    public UserExistsException(String message) {
        super(message);
        setErrorCode(ErrorCodes.USER_EXISTS);
        setStatus(400);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause);
        setErrorCode(ErrorCodes.USER_EXISTS);
        setStatus(400);
    }

    public UserExistsException(Throwable cause) {
        super(cause);
        setErrorCode(ErrorCodes.USER_EXISTS);
        setStatus(400);
    }
}
