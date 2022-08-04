package com.appdynamics.demo.java.order.entities.request;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import lombok.Data;

@Data
public class OrderRequest {

    private UUID customerId;
    private List<OrderRequestPosition> positions = new LinkedList<>();

}
