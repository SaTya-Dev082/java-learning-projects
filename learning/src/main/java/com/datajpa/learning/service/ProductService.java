package com.datajpa.learning.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datajpa.learning.entity.Product;
import com.datajpa.learning.repository.ProductRepository;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        return repository.save(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Product getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
    }

    @Transactional
    public Product update(Long id, Product request) {
        Product current = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + id));
        current.setName(request.getName());
        current.setPrice(request.getPrice());
        current.setQuantity(request.getQuantity());
        current.setDescription(request.getDescription());
        // current គឺ managed entity; Hibernate dirty checking អាច sync changes ពេល
        // flush/commit
        return current;
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Product not found: " + id);
        }
        repository.deleteById(id);
    }
}
