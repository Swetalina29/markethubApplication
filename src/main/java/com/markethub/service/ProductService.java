package com.markethub.service;

import com.markethub.model.Product;
import com.markethub.model.Product.Category;
import com.markethub.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // CREATE
    public Product createProduct(Product product) {
        if (product.getPrice() <= 0)
            throw new IllegalArgumentException("Price must be greater than 0");
        if (product.getStock() < 0)
            throw new IllegalArgumentException("Stock cannot be negative");
        return productRepository.save(product);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // READ ONE
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // SEARCH
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    // FILTER BY CATEGORY
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    // FILTER BY PRICE RANGE
    public List<Product> getProductsByPriceRange(Double min, Double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    // UPDATE
    public Product updateProduct(Long id, Product updated) {
        Product existing = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found: " + id));
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        existing.setPrice(updated.getPrice());
        existing.setStock(updated.getStock());
        existing.setImageUrl(updated.getImageUrl());
        existing.setCategory(updated.getCategory());
        existing.setSeller(updated.getSeller());
        return productRepository.save(existing);
    }

    // DELETE
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id))
            throw new RuntimeException("Product not found: " + id);
        productRepository.deleteById(id);
    }

    // PURCHASE (reduce stock)
    public Product purchaseProduct(Long id, int quantity) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found: " + id));
        if (product.getStock() < quantity)
            throw new RuntimeException("Not enough stock! Available: " + product.getStock());
        product.setStock(product.getStock() - quantity);
        return productRepository.save(product);
    }
}