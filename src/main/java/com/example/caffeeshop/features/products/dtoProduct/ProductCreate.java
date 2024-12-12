package com.example.caffeeshop.features.products.dtoProduct;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProductCreate(
         String codeProduct,
         @NotEmpty(message = "tile is not blank please input")
         String tile,
         @NotEmpty(message = "metaTile is not empty")
         String metaTile,
         @NotBlank(message = "slug is not null")
         String slug,
         Float price,
         Integer quantity,
         Integer discount,
         Float priceDiscount,
         String shop,
         Date endDate,
         String image,
         String content,

         String nameCategory
) {
}
