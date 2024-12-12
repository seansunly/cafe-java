package com.example.caffeeshop.features.category;

import com.example.caffeeshop.doman.Category;
import com.example.caffeeshop.features.category.dto.CategoryCreate;
import com.example.caffeeshop.features.category.dto.CategoryResponse;
import com.example.caffeeshop.features.category.dto.CategoryUpdate;
import com.example.caffeeshop.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryResponse createCategory(CategoryCreate categoryCreate) {
        if(categoryRepository.existsByTitle(categoryCreate.title())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Title already exists");
        }
        Category category =categoryMapper.createCategory(categoryCreate);

        category.setIsDeleted(false);
        category.setCodeCategory(UUID.randomUUID().toString());
        category= categoryRepository.save(category);

        return categoryMapper.entityToDto(category);
    }

    @Override
    public CategoryResponse updateCategory(String codeCategory,CategoryUpdate categoryUpdate) {
        Category category=categoryRepository.findByCodeCategory(codeCategory)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryMapper.updateCategory(category,categoryUpdate);
        category=categoryRepository.save(category);

        return categoryMapper.entityToDto(category);
    }

    @Override
    public void deleteCategory(String codeCategory) {
        Category category =categoryRepository.findByCodeCategory(codeCategory)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryRepository.delete(category);

    }

    @Override
    public CategoryResponse getCategoryByCode(String codeCategory) {
        Category category =categoryRepository.findByCodeCategory(codeCategory)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        category=categoryRepository.save(category);

        return categoryMapper.entityToDto(category);
    }

    @Override
    public CategoryResponse isDeletedByCodeCategory(String codeCategory) {
        Category category =categoryRepository.findByCodeCategory(codeCategory)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        category.setIsDeleted(true);
        category=categoryRepository.save(category);
        return categoryMapper.entityToDto(category);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.entityListToDto(categoryList);
    }
}
