package com.appdynamics.demo.java.customer.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.appdynamics.demo.java.customer.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}