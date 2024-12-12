package com.example.caffeeshop.mapper;

import com.example.caffeeshop.doman.Product;
import com.example.caffeeshop.features.category.dto.CategoryResponse;
import com.example.caffeeshop.features.products.dtoProduct.ProductCreate;
import com.example.caffeeshop.features.products.dtoProduct.ProductResponse;
import com.example.caffeeshop.features.products.dtoProduct.ProductUpdate;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "nameCategory",target = "category.title")
    Product createProduct(ProductCreate productCreate);
    //isDeletedCategory
    @Mapping(source ="category.title" ,target = "nameCategory")
    @Mapping(source ="category.isDeleted" ,target = "isDeletedCategory")
    ProductResponse entityToResponse(Product product);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProduct(@MappingTarget Product product, ProductUpdate productUpdate);

    List<ProductResponse> entityToResponseList(List<Product> productList);
}
