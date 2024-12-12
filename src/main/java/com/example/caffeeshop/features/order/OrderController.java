package com.example.caffeeshop.features.order;

import com.example.caffeeshop.features.order.dtoOrder.OrderCreate;
import com.example.caffeeshop.features.order.dtoOrder.OrderResponse;
import com.example.caffeeshop.features.order.dtoOrder.OrderUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the front-end
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody OrderCreate orderCreate) {
        return orderService.createOrder(orderCreate);
    }

    @GetMapping
    public List<OrderResponse> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{codeOrder}")
    public OrderResponse getOrder(@PathVariable String codeOrder) {
        return orderService.getOrder(codeOrder);
    }

    @DeleteMapping("/{codeOrder}")
    public void deleteOrder(@PathVariable String codeOrder) {
        orderService.deleteOrder(codeOrder);
    }

    @PatchMapping("/{codeOrder}")
    public OrderResponse updateOrder(@PathVariable String codeOrder, @Valid @RequestBody OrderUpdate orderUpdate) {
        return orderService.updateOrder(codeOrder, orderUpdate);
    }
}
