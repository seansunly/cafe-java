package com.example.caffeeshop.features.order.dtoOrder;

import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

public record OrderCreate(
         String codeOrder,
//         @NotEmpty(message = "description is input ")
         String description,
         //Float subTotal,
         //Float itemDiscount,
         Float shippingCost,
         Float total,
         String promo,
         Float discount,
         Float greteTotal,
         Integer quantity,
         String city,
         String province,
         String country,
         Date createAt,
         Date updateAt,
         String content,
         String codeUser,

         List<String> codeProduct
) {
}
