package com.codedsalis.ecom.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @Valid

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 255)
    private String name;

    @NotBlank(message = "Email address is required")
    @Email(message = "Invalid email format")
    @Size(min = 5, max = 255)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 3, max = 255)
    private String password;
}
