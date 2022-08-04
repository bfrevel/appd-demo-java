package com.appdynamics.demo.java.order.entities.request;

import java.util.UUID;

import lombok.Data;

@Data
public class OrderRequestPosition {
    private int quantity;
    private UUID productId;
}
