package com.example.caffeeshop.features.category;

import com.example.caffeeshop.features.category.dto.CategoryCreate;
import com.example.caffeeshop.features.category.dto.CategoryResponse;
import com.example.caffeeshop.features.category.dto.CategoryUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/category")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the front-end
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{codeCategory}")
    public CategoryResponse getCategory(@PathVariable String codeCategory) {
        return categoryService.getCategoryByCode(codeCategory);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public CategoryResponse createCategory(@Valid @RequestBody CategoryCreate categoryCreate) {
        return categoryService.createCategory(categoryCreate);
    }

    @DeleteMapping("/{codeCategory}")
    public void deleteCategory(@PathVariable String codeCategory) {
        categoryService.deleteCategory(codeCategory);
    }

    @PatchMapping("/{codeCategory}")
    public CategoryResponse updateCategory(@PathVariable String codeCategory, @Valid @RequestBody CategoryUpdate categoryUpdate) {
        return categoryService.updateCategory(codeCategory, categoryUpdate);
    }

    @PatchMapping("/{codeCategory}/isDeletedByCode")
    public CategoryResponse isDeletedByCodeCategory(@PathVariable String codeCategory) {
        return categoryService.isDeletedByCodeCategory(codeCategory);
    }


}
