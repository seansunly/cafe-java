package com.example.caffeeshop.features.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryCreate(

        String title,
        @NotBlank(message = "meta tile is required")
        String metaTile,
        @NotBlank(message = "meta tile is required")
        String slug,
        String text
//        @NotBlank(message = "is deleted is required")
//        Boolean isDeleted
) {
}
