package com.example.caffeeshop.mapper;

import com.example.caffeeshop.doman.Order;
import com.example.caffeeshop.features.order.dtoOrder.OrderCreate;
import com.example.caffeeshop.features.order.dtoOrder.OrderResponse;
import com.example.caffeeshop.features.order.dtoOrder.OrderUpdate;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    //@Mapping(source = "codeProduct" ,target = "products.codeProduct")
    @Mapping(source = "codeUser",target = "user.codeUser")
    Order createOrderResponse(OrderCreate orderCreate);
    @Mapping(source = "products",target = "products")
    @Mapping(source = "user.codeUser",target = "codeUser")
    OrderResponse entityToOrderResponse(Order order);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateOrderResponse(@MappingTarget Order order, OrderUpdate orderUpdate);

    List<OrderResponse> orderList(List<Order> orderList);
}
