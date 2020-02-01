package com.example.demo.resource;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> products() {

        return productRepository.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product productFromView) {

        return productService.save(productFromView);
    }

    @PostMapping(path = "/delete")
    public void delete(@RequestBody Product productFromView) {

        productRepository.delete(productFromView);
    }
}
