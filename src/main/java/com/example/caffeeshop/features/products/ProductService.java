package com.example.caffeeshop.features.products;

import com.example.caffeeshop.features.category.dto.CategoryResponse;
import com.example.caffeeshop.features.products.dtoProduct.ProductCreate;
import com.example.caffeeshop.features.products.dtoProduct.ProductResponse;
import com.example.caffeeshop.features.products.dtoProduct.ProductUpdate;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductCreate productCreate);
    ProductResponse updateProduct(String codeProduct,ProductUpdate productUpdate);
    void deleteProduct(String codeProduct);
    ProductResponse getProduct(String codeProduct);
    List<ProductResponse> getProducts();

    ProductResponse isDeletedProduct(String codeProduct);
    ProductResponse productInStockNotHave(String codeProduct);

}
