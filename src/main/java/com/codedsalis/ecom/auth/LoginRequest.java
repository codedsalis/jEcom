package com.codedsalis.ecom.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Valid

    @NotBlank(message = "Email address is required")
    @NotNull
    private String email;

    @NotBlank(message = "Password is required")
    @NotNull
    private String password;
}
