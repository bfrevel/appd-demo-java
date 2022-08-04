package com.appdynamics.demo.java.customer.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.appdynamics.demo.java.customer.entities.Customer;
import com.appdynamics.demo.java.customer.repositories.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/customer")
@Log4j2
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping(path = "/{id}")
    public Optional<Customer> get(@PathVariable UUID id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            log.info("[x] returning '{}}'", customer);
            return customer;
        } else {
            log.error("[x] Customer not found '{}}'", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found");
        }
    }

}
