package com.example.demo.service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {

        Double vat = null;
        if (product.getProductValue() != null && product.getQty() != null) {
            vat = ((product.getProductValue() * product.getQty()) /100) * 7;
        }
        product.setVat(vat);

        return productRepository.save(product);
    }
}
