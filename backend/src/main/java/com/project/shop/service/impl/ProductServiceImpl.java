package com.project.shop.service.impl;

import com.project.shop.model.Product;
import com.project.shop.repository.ProductRepository;
import com.project.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    public final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Product result = productRepository.findById(id).orElse(null);
        if (result == null){
            log.warn("IN findById - no product found by id {}",id);
            return null;
        }
            log.info("IN findById - product: {} found by id: {}", result);
            return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
        log.info("IN delete - product with id: {} successfully deleted");
    }
}