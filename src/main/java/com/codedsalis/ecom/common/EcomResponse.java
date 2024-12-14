package com.codedsalis.ecom.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EcomResponse<T> {
    private Boolean status;

    private T data;
}
