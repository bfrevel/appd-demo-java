package com.appdynamics.demo.java.load.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderPosition {
    private int quantity;
    private UUID productId;
}