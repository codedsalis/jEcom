package com.codedsalis.ecom.category.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategory {

    @Valid

    @NotNull(message = "Name cannot be empty")
    @NotEmpty(message = "Name is required")
    @Size(max = 255)
    private String name;
}
