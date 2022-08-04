package com.appdynamics.demo.java.product.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.appdynamics.demo.java.product.entities.Product;
import com.appdynamics.demo.java.product.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping(path = "/{id}")
    public Optional<Product> get(@PathVariable UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            log.info("[x] returning '{}}'", product);
            return product;
        } else {
            log.error("[x] Product not found '{}}'", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
        }
    }

}
