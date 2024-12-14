package com.codedsalis.ecom.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {
    public <T> ResponseEntity<EcomResponse<T>> success(T data) {
        EcomResponse<T> response = new EcomResponse<>(true, data);
        return ResponseEntity.ok(response);
    }

    public <T> ResponseEntity<EcomResponse<T>> success(T data, HttpStatus code) {
        EcomResponse<T> response = new EcomResponse<>(true, data);
        return ResponseEntity.status(code).body(response);
    }

    public ResponseEntity<Void> noContent() {
        return ResponseEntity.noContent().build();
    }
}
