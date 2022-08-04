package com.appdynamics.demo.java.order.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {

    private final RabbitConfigProperties rabbitConfigProperties;

    @Bean
    public Queue registrationQueue() {
        return new Queue(rabbitConfigProperties.getOrderQueue());
    }
    
}
