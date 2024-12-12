package com.example.caffeeshop.features.order;

import com.example.caffeeshop.doman.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByCodeOrder(String codeOrder);
    Boolean existsByCodeOrder(String codeOrder);

}
