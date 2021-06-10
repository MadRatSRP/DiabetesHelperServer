package com.madrat.diabeteshelperserver.groups.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("/")
    public Iterable<Product> getAllProducts() {
        return repository.findAll();
    }
}
