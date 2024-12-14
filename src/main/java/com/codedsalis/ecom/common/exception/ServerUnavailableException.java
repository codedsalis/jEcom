package com.codedsalis.ecom.common.exception;


import org.springframework.http.HttpStatus;

public class ServerUnavailableException extends EcomException {
    public ServerUnavailableException(String message) {
        super(message);
    }

    public ServerUnavailableException(String message, HttpStatus code) {
        super(message, code);
    }

}
