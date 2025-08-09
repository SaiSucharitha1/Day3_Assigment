package com.example.productordersystem;

import com.example.productordersystem.entity.Product;
import com.example.productordersystem.repository.ProductRepository;
import com.example.productordersystem.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {
        Product product = new Product(null, "Laptop", 50000.0, 10);
        Product savedProduct = new Product(1L, "Laptop", 50000.0, 10);

        when(productRepository.save(product)).thenReturn(savedProduct);

        Product result = productService.addProduct(product);
        assertEquals("Laptop", result.getName());
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = Arrays.asList(
                new Product(1L, "TV", 30000.0, 5),
                new Product(2L, "Phone", 15000.0, 8)
        );
        when(productRepository.findAll()).thenReturn(products);

        List<Product> result = productService.getAllProducts();
        assertEquals(2, result.size());
    }

    @Test
    void testUpdateProduct() {
        Product existing = new Product(1L, "Tablet", 20000.0, 6);
        Product updated = new Product(null, "Tablet Pro", 25000.0, 7);
        Product saved = new Product(1L, "Tablet Pro", 25000.0, 7);

        when(productRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(productRepository.save(any(Product.class))).thenReturn(saved);

        Product result = productService.updateProduct(1L, updated);

        assertEquals("Tablet Pro", result.getName());
        assertEquals(25000.0, result.getPrice());
    }
}
