package com.example.caffeeshop.features.category;

import com.example.caffeeshop.doman.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByTitle(String tile);
    Boolean existsByTitle(String tile);
    Optional<Category> findByCodeCategory(String codeCategory);
    Boolean existsByCodeCategory(String codeCategory);
}
