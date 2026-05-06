package com.markethub.repository;

import com.markethub.model.Product;
import com.markethub.model.Product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);

    List<Product> findBySeller(String seller);

    List<Product> findByNameContainingIgnoreCase(String keyword);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);

    @Query("SELECT p FROM Product p WHERE p.stock > 0")
    List<Product> findInStockProducts();
}