package com.codedsalis.ecom.user.exception;

import com.codedsalis.ecom.common.exception.EcomException;

public class UserCreationException extends EcomException {
    public UserCreationException(String message) {
        super(message);
    }

    public UserCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
