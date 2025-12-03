package com.varaha.web.controller;

import com.varaha.common.model.Order;
import com.varaha.common.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService = new OrderService();

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return orderService.getOrderById(id);
    }
}
