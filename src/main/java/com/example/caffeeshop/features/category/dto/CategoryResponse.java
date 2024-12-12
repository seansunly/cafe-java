package com.example.caffeeshop.features.category.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record CategoryResponse(
         String codeCategory,
         String title,
         String metaTile,
         String slug,
         String text,
         Boolean isDeleted
) {
}
