package com.example.caffeeshop.exception;

import lombok.Builder;

@Builder
public record FieldErrorResponse(
        String field,
        String detail
) {
}
