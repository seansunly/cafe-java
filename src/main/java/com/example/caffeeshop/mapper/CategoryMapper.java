package com.example.caffeeshop.mapper;

import com.example.caffeeshop.doman.Category;
import com.example.caffeeshop.features.category.dto.CategoryCreate;
import com.example.caffeeshop.features.category.dto.CategoryResponse;
import com.example.caffeeshop.features.category.dto.CategoryUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category createCategory(CategoryCreate categoryCreate);
    CategoryResponse entityToDto(Category category);

    void updateCategory(@MappingTarget Category category , CategoryUpdate categoryUpdate);

    List<CategoryResponse> entityListToDto(List<Category> categoryList);

}
