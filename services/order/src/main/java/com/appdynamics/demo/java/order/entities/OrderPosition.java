package com.appdynamics.demo.java.order.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderPosition {
    private int quantity;
    private Product product;
}
