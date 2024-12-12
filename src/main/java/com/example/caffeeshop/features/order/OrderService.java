package com.example.caffeeshop.features.order;

import com.example.caffeeshop.doman.Order;
import com.example.caffeeshop.features.order.dtoOrder.OrderCreate;
import com.example.caffeeshop.features.order.dtoOrder.OrderResponse;
import com.example.caffeeshop.features.order.dtoOrder.OrderUpdate;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderCreate orderCreate);
    OrderResponse getOrder(String codeOrder);
    OrderResponse updateOrder(String codeOrder, OrderUpdate orderUpdate);
    void deleteOrder(String codeOrder);
    List<OrderResponse> getOrders();
}
