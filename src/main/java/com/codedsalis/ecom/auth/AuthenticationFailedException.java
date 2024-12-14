package com.codedsalis.ecom.auth;

import com.codedsalis.ecom.common.exception.EcomException;
import org.springframework.http.HttpStatus;

public class AuthenticationFailedException extends EcomException {
    public AuthenticationFailedException(String message) {
        super(message);
    }

    public AuthenticationFailedException(String message, HttpStatus code) {
        super(message, code);
    }
}
