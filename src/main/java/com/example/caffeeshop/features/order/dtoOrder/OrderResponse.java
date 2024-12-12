package com.example.caffeeshop.features.order.dtoOrder;

import com.example.caffeeshop.features.products.dtoProduct.ProductResponse;

import java.util.Date;
import java.util.List;

public record OrderResponse(
        String codeOrder,
        String description,
        //Float subTotal,
       // Float itemDiscount,
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


        List<ProductResponse> products
) {
}
