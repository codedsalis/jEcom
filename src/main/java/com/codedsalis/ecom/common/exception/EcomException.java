package com.codedsalis.ecom.common.exception;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@MappedSuperclass()
@EqualsAndHashCode(callSuper = true)
public class EcomException extends RuntimeException {
    private HttpStatus code;

    public EcomException(String message) {
        super(message);
    }

    public EcomException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }

    public EcomException(String message, Throwable cause) {
        super(message, cause);
    }

    public EcomException(String message, HttpStatus code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
