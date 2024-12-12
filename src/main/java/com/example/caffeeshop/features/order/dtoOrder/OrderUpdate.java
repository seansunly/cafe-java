package com.example.caffeeshop.features.order.dtoOrder;

import java.util.Date;

public record OrderUpdate(
        String codeOrder,
        String description,
        //Float subTotal,
        Float itemDiscount,
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
        String content
) {
}
