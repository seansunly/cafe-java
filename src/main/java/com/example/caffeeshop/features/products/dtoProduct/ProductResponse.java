package com.example.caffeeshop.features.products.dtoProduct;

import java.util.Date;

public record ProductResponse(
        String codeProduct,
        String tile,
        String metaTile,
        String slug,
        Float price,
        Integer quantity,
        Integer discount,
        Float priceDiscount,
        String shop,
        Date createAt,
        Date updateAt,
        Date startDate,
        Date endDate,
        String image,
        String content,
        Boolean isDeleted,
        Boolean haveNotInStock,

        String nameCategory,
        Boolean isDeletedCategory
) {
}
