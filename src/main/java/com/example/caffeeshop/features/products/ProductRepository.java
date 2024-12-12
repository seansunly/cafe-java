package com.example.caffeeshop.features.products;

import com.example.caffeeshop.doman.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByCodeProduct(String codeProduct);
    Boolean existsByCodeProduct(String codeProduct);
}
