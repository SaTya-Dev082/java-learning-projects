package com.datajpa.learning.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.datajpa.learning.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByNameContaining(String text);

    List<Product> findByNameContainingIgnoreCase(String text);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByPriceLessThan(BigDecimal price);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    List<Product> findByNameAndQuantity(String name, Integer quantity);

    List<Product> findByNameOrDescription(String name, String description);

    List<Product> findAllByOrderByPriceAsc();

    List<Product> findAllByOrderByPriceDesc();

    boolean existsByName(String name);

    long countByName(String name);
}
