package com.example.productordersystem.service;

import com.example.productordersystem.entity.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Long productId, Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
