package com.appdynamics.demo.java.load.components;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.appdynamics.demo.java.load.config.CustomerServiceConfigProperties;
import com.appdynamics.demo.java.load.config.OrderServiceConfigProperties;
import com.appdynamics.demo.java.load.config.ProductServiceConfigProperties;
import com.appdynamics.demo.java.load.entities.Order;
import com.appdynamics.demo.java.load.entities.OrderPosition;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@RequiredArgsConstructor
public class LoadScheduler {

        private final CustomerServiceConfigProperties customerServiceConfigProperties;
        private final ProductServiceConfigProperties productServiceConfigProperties;
        private final OrderServiceConfigProperties orderServiceConfigProperties;
        private final Customers customers;
        private final Products products;
        private final RestTemplate restTemplate = new RestTemplate();

        private static String ORDER_SERVICE_URL = "http://%s:%s/api/%s";
        private static String CUSTOMER_SERVICE_URL = "http://%s:%s/api/%s";
        private static String HEALTH_URL = "http://%s:%s/actuator/health";

        private static String HEALTH_LOG_MSG = "[x] {} health: '{}'";
        private static String ORDER_LOG_MSG_PRE = "[x] creating order: '{}'";
        private static String ORDER_LOG_MSG_POST = "[x] created order: '{}'";
        private static String CUSTOMER_LOG_MSG_PRE = "[x] getting customer: '{}'";
        private static String CUSTOMER_LOG_MSG_POST = "[x] got customer: '{}'";

        @Scheduled(fixedRate = 1000)
        public void testOrderService() {

                List<OrderPosition> orderPositions = new LinkedList<>();
                int positions = ThreadLocalRandom.current().nextInt(1, 6);
                for (int i = 0; i < positions; i++) {
                        int quantity = ThreadLocalRandom.current().nextInt(1, 11);
                        orderPositions.add(new OrderPosition(quantity, products.getRandomProduct()));
                }
                Order orderRequest = new Order(customers.getRandomValidCustomer(), orderPositions);

                log.info(ORDER_LOG_MSG_PRE, orderRequest);

                String jsonString = this.restTemplate.postForObject(
                                String.format(ORDER_SERVICE_URL, orderServiceConfigProperties.getHost(),
                                                orderServiceConfigProperties.getPort(), "order"),
                                orderRequest,
                                String.class);

                log.info(ORDER_LOG_MSG_POST, jsonString);

        }

        @Scheduled(fixedRate = 10000)
        public void testCustomerService() {

                UUID invalidCustomer = customers.getRandomInvalidCustomer();

                log.info(CUSTOMER_LOG_MSG_PRE, invalidCustomer);

                String jsonString = this.restTemplate.getForObject(
                                String.format(CUSTOMER_SERVICE_URL, customerServiceConfigProperties.getHost(),
                                                customerServiceConfigProperties.getPort(), "customer")
                                                .concat(String.format("/%s", invalidCustomer)),
                                String.class);

                log.info(CUSTOMER_LOG_MSG_POST, jsonString);

        }

        @Scheduled(fixedRate = 30000)
        public void healthCheckCustomerService() {
                String health = this.restTemplate.getForObject(
                                String.format(HEALTH_URL, customerServiceConfigProperties.getHost(),
                                                customerServiceConfigProperties.getPort()),
                                String.class);
                log.info(HEALTH_LOG_MSG, "customer", health);
        }

        @Scheduled(fixedRate = 30000)
        public void healthCheckProductService() {
                String health = this.restTemplate.getForObject(
                                String.format(HEALTH_URL, productServiceConfigProperties.getHost(),
                                                productServiceConfigProperties.getPort()),
                                String.class);
                log.info(HEALTH_LOG_MSG, "product", health);
        }

        @Scheduled(fixedRate = 30000)
        public void healthCheckOrderService() {
                String health = this.restTemplate.getForObject(
                                String.format(HEALTH_URL, orderServiceConfigProperties.getHost(),
                                                orderServiceConfigProperties.getPort()),
                                String.class);
                log.info(HEALTH_LOG_MSG, "order", health);
        }

}
