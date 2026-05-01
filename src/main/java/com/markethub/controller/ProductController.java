package com.markethub.controller;

import com.markethub.model.Product;
import com.markethub.model.Product.Category;
import com.markethub.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET all products
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // GET one product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productService.getProductById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // GET search by keyword
    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(@RequestParam String keyword) {
        return ResponseEntity.ok(productService.searchProducts(keyword));
    }

    // GET filter by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> byCategory(@PathVariable Category category) {
        return ResponseEntity.ok(productService.getProductsByCategory(category));
    }

    // GET filter by price range
    @GetMapping("/price-range")
    public ResponseEntity<List<Product>> byPrice(
            @RequestParam Double min, @RequestParam Double max) {
        return ResponseEntity.ok(productService.getProductsByPriceRange(min, max));
    }

    // POST create new product
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(productService.createProduct(product));
    }

    // PUT update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    // DELETE product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // POST purchase (reduces stock)
    @PostMapping("/{id}/purchase")
    public ResponseEntity<?> purchase(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") int quantity) {
        try {
            return ResponseEntity.ok(productService.purchaseProduct(id, quantity));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}