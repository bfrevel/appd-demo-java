package com.appdynamics.demo.java.product.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.appdynamics.demo.java.product.entities.Product;

public interface ProductRepository extends CrudRepository<Product, UUID> {
}