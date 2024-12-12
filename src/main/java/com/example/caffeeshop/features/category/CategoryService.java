package com.example.caffeeshop.features.category;

import com.example.caffeeshop.features.category.dto.CategoryCreate;
import com.example.caffeeshop.features.category.dto.CategoryResponse;
import com.example.caffeeshop.features.category.dto.CategoryUpdate;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryCreate categoryCreate);
    CategoryResponse updateCategory(String codeCategory,CategoryUpdate categoryUpdate);
    void deleteCategory(String codeCategory);
    CategoryResponse getCategoryByCode(String codeCategory);
    CategoryResponse isDeletedByCodeCategory(String codeCategory);
    List<CategoryResponse> getAllCategories();

}
