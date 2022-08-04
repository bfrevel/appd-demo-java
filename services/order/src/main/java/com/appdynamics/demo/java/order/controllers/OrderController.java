package com.appdynamics.demo.java.order.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.appdynamics.demo.java.order.config.CustomerServiceConfigProperties;
import com.appdynamics.demo.java.order.config.ProductServiceConfigProperties;
import com.appdynamics.demo.java.order.entities.Customer;
import com.appdynamics.demo.java.order.entities.Order;
import com.appdynamics.demo.java.order.entities.OrderPosition;
import com.appdynamics.demo.java.order.entities.Product;
import com.appdynamics.demo.java.order.entities.request.OrderRequest;
import com.appdynamics.demo.java.order.entities.request.OrderRequestPosition;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/order")
@Log4j2
@RequiredArgsConstructor
public class OrderController {

    private final CustomerServiceConfigProperties customerServiceConfigProperties;
    private final ProductServiceConfigProperties productServiceConfigProperties;
    private final RestTemplate restTemplate = new RestTemplate();

    private static String SERVICE_URL = "http://%s:%s/api/%s";
    private static String LOG_MSG = "[x] requested {}: '{}'";

    @PostMapping()
    public Optional<Order> post(@RequestBody OrderRequest orderRequest) {

        Customer customer = null;
        try {
            customer = restTemplate
                    .getForEntity(
                            String.format(SERVICE_URL,
                                    customerServiceConfigProperties.getHost(),
                                    customerServiceConfigProperties.getPort(),
                                    "customer")
                                    + "/{id}",
                            Customer.class, orderRequest.getCustomerId())
                    .getBody();
            log.info(LOG_MSG,"customer", customer);
        } catch (HttpClientErrorException exception) {
            log.error("[x] Customer not found '{}}'", orderRequest.getCustomerId());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found");
        }

        List<OrderPosition> positions = new LinkedList<>();
        for (OrderRequestPosition requestPosition : orderRequest.getPositions()) {
            try {
                Product product = restTemplate
                        .getForEntity(String.format(SERVICE_URL,
                                productServiceConfigProperties.getHost(),
                                productServiceConfigProperties.getPort(), "product") + "/{id}",
                                Product.class,
                                requestPosition.getProductId())
                        .getBody();
                log.info(LOG_MSG, "product", product);
                positions.add(new OrderPosition(requestPosition.getQuantity(), product));
            } catch (HttpClientErrorException exception) {
                log.error("[x] Product not found '{}}'", requestPosition.getProductId());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found");
            }
        }

        Order order = new Order(UUID.randomUUID(), customer, positions);

        log.info("order {}", order);
        return Optional.ofNullable(order);
    }

}
