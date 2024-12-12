package com.example.caffeeshop.features.products;

import com.example.caffeeshop.features.products.dtoProduct.ProductCreate;
import com.example.caffeeshop.features.products.dtoProduct.ProductResponse;
import com.example.caffeeshop.features.products.dtoProduct.ProductUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the front-end
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ProductResponse createProduct(@Valid @RequestBody ProductCreate productCreate) {
        return productService.createProduct(productCreate);
    }

    @PatchMapping("/{codeProduct}")
    public ProductResponse updateProduct(@PathVariable String codeProduct ,@Valid @RequestBody ProductUpdate productUpdate) {
        return productService.updateProduct(codeProduct, productUpdate);
    }
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getProducts();
    }
    @GetMapping("/{codeProduct}")
    public ProductResponse getProduct(@PathVariable String codeProduct) {
        return productService.getProduct(codeProduct);
    }

    @DeleteMapping("/{codeProduct}")
    public void deleteProduct(@PathVariable String codeProduct) {
        productService.deleteProduct(codeProduct);
    }

    @PatchMapping("/{codeProduct}/isDeleted")
    public ProductResponse isDeletedProduct(@PathVariable String codeProduct) {
        return productService.isDeletedProduct(codeProduct);
    }
    @PatchMapping("/{codeProduct}/haveNOtInStock")
    public ProductResponse haveNotInStockProduct(@PathVariable String codeProduct) {
        return productService.productInStockNotHave(codeProduct);
    }
}
