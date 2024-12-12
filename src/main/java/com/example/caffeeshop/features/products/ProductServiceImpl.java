package com.example.caffeeshop.features.products;

import com.example.caffeeshop.doman.Category;
import com.example.caffeeshop.doman.Product;
import com.example.caffeeshop.features.category.CategoryRepository;
import com.example.caffeeshop.features.category.dto.CategoryResponse;
import com.example.caffeeshop.features.products.dtoProduct.ProductCreate;
import com.example.caffeeshop.features.products.dtoProduct.ProductResponse;
import com.example.caffeeshop.features.products.dtoProduct.ProductUpdate;
import com.example.caffeeshop.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    @Override
    public ProductResponse createProduct(ProductCreate productCreate) {
        if(productRepository.existsByCodeProduct(productCreate.codeProduct())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"product is already exist");
        }
        Category category = categoryRepository.findByTitle(productCreate.nameCategory())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"nameCategory not found"));

        Product product = productMapper.createProduct(productCreate);
        product.setCodeProduct(UUID.randomUUID().toString());
        product.setCreateAt(Date.from(Instant.now()));
        product.setUpdateAt(Date.from(Instant.now()));
        product.setStartDate(Date.from(Instant.now()));
        product.setIsDeleted(false);
        product.setHaveNotInStock(false);
        product.setCategory(category);
        // Calculate and set price details
        double discount = product.getDiscount(); // Assuming this is a percentage
        double price = product.getPrice();
        product.setPriceDiscount((float) (price - (price * discount / 100)));
        product= productRepository.save(product);
//
        return productMapper.entityToResponse(product);
    }

    @Override
    public ProductResponse updateProduct(String codeProduct, ProductUpdate productUpdate) {
        Product product = productRepository.findByCodeProduct(codeProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found"));

        productMapper.updateProduct(product, productUpdate);
        product.setUpdateAt(Date.from(Instant.now()));
        product=productRepository.save(product);
        return productMapper.entityToResponse(product);
    }

    @Override
    public void deleteProduct(String codeProduct) {
        Product product = productRepository.findByCodeProduct(codeProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found"));
        productRepository.delete(product);
    }

    @Override
    public ProductResponse getProduct(String codeProduct) {
        Product product = productRepository.findByCodeProduct(codeProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found"));
        product= productRepository.save(product);

        return productMapper.entityToResponse(product);
    }

    @Override
    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        return productMapper.entityToResponseList(products);
    }

    @Override
    public ProductResponse isDeletedProduct(String codeProduct) {
        Product product = productRepository.findByCodeProduct(codeProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found"));
        product.setIsDeleted(true);
        product=productRepository.save(product);
        return productMapper.entityToResponse(product);
    }

    @Override
    public ProductResponse productInStockNotHave(String codeProduct) {
        Product product = productRepository.findByCodeProduct(codeProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"product not found"));
        product.setHaveNotInStock(true);
        product=productRepository.save(product);
        return productMapper.entityToResponse(product);
    }
}
