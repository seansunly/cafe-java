package com.example.caffeeshop.features.order;

import com.example.caffeeshop.doman.Order;
import com.example.caffeeshop.doman.Product;
import com.example.caffeeshop.doman.User;
import com.example.caffeeshop.features.order.dtoOrder.OrderCreate;
import com.example.caffeeshop.features.order.dtoOrder.OrderResponse;
import com.example.caffeeshop.features.order.dtoOrder.OrderUpdate;
import com.example.caffeeshop.features.products.ProductRepository;
import com.example.caffeeshop.features.user.UserRepository;
import com.example.caffeeshop.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    public OrderResponse createOrder(OrderCreate orderCreate) {
        // Check if order code already exists
        if (orderRepository.existsByCodeOrder(orderCreate.codeOrder())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Order code already exists");
        }

        // Find user by codeUser
        User user = userRepository.findByCodeUser(orderCreate.codeUser())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // Retrieve the list of product codes from the orderCreate object
        List<String> productCodes = orderCreate.codeProduct();

        // Fetch the corresponding products based on the provided codes
        List<Product> productList = new ArrayList<>();
        for (String productCode : productCodes) {
            // Fetch product by codeProduct, throw exception if not found
            Product product = productRepository.findByCodeProduct(productCode)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product code " + productCode + " not found"));

            // Add the fetched product to the product list
            productList.add(product);
        }

//        // Calculate Total: Sum of the prices of all products multiplied by their quantities
//        double total = productList.stream()
//                .mapToDouble(product -> product.getPrice() * product.getQuantity())  // Multiply price and quantity
//                .sum();
//
//        // Calculate Grand Total: Subtract discount from the total for each product
//        double grandTotal = productList.stream()
//                .mapToDouble(product -> (product.getPrice() - product.getDiscount()) * product.getQuantity())
//                .sum();
//
//        // Calculate Total Discount: Sum of discounts for all products (considering quantities)
//        double totalDiscount = productList.stream()
//                .mapToDouble(product -> product.getDiscount() * product.getQuantity())
//                .sum();
//
//        // Calculate Total Quantity: Sum of quantities for all products in the order
//        int totalQuantity = productList.stream()
//                .mapToInt(Product::getQuantity)
//                .sum();

        // Create the Order entity
        Order order = orderMapper.createOrderResponse(orderCreate);
        order.setCodeOrder(UUID.randomUUID().toString()); // Generate a new unique order code
        order.setCreateAt(Date.from(Instant.now())); // Set creation timestamp
        order.setUpdateAt(Date.from(Instant.now())); // Set update timestamp (can be updated later)
        order.setProducts(productList); // Set the list of products
//        order.setQuantity(totalQuantity); // Set total quantity of all products
//        order.setTotal((float) total); // Set total price (before discount)
//        order.setGreteTotal((float) grandTotal); // Set grand total (after discount)
//        order.setDiscount((float) totalDiscount); // Set total discount
        order.setUser(user); // Associate the user with the order

        // Save the order to the repository
        order = orderRepository.save(order);

        // Return the response DTO
        return orderMapper.entityToOrderResponse(order);
    }



    @Override
    public OrderResponse getOrder(String codeOrder) {
        Order order = orderRepository.findByCodeOrder(codeOrder)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"order not found"));

        order = orderRepository.save(order);
        return orderMapper.entityToOrderResponse(order);
    }

    @Override
    public OrderResponse updateOrder(String codeOrder, OrderUpdate orderUpdate) {
        Order order = orderRepository.findByCodeOrder(codeOrder)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"order not found"));
        orderMapper.updateOrderResponse(order, orderUpdate);
        order.setUpdateAt(Date.from(Instant.now()));
        order = orderRepository.save(order);
        return orderMapper.entityToOrderResponse(order);
    }

    @Override
    public void deleteOrder(String codeOrder) {
        Order order = orderRepository.findByCodeOrder(codeOrder)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"order not found"));

        orderRepository.delete(order);
    }

    @Override
    public List<OrderResponse> getOrders() {
        List<Order> orderList = orderRepository.findAll();
        return orderMapper.orderList(orderList);
    }
}
