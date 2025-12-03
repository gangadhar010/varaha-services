package com.varaha.web.controller;

import com.varaha.common.model.Order;
import com.varaha.common.model.OrderSummary;
import com.varaha.common.service.OrderService;
import com.varaha.web.dto.CheckoutRequest;
import com.varaha.web.dto.CheckoutResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<CheckoutResponse> checkout(@Valid @RequestBody CheckoutRequest request) {
        // In a real app, the service would return the full CheckoutResponse
        Order order = orderService.createOrderFromCheckout(
            request.getCartId(),
            request.getPaymentMethod(),
            request.getPaymentProvider()
        );

        CheckoutResponse response = new CheckoutResponse();
        response.setOrder(order);
        // Payment ID and redirect URL would be determined by the payment integration
        response.setPaymentId("pi_mock_" + System.currentTimeMillis());
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        Order order = orderService.getOrderById(orderId);
        // Handle null case for 404
        return ResponseEntity.ok(order);
    }

    // This endpoint is defined as /users/{userId}/orders, so it might be better
    // placed in UserController, but keeping it here for cohesion with Orders API spec.
    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<OrderSummary>> getOrdersForUser(
            @PathVariable String userId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "20") int size) {
        
        // Page number in Spring Data is 0-indexed, but API is 1-indexed.
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<OrderSummary> orders = orderService.getOrdersByUserId(userId, pageable);
        return ResponseEntity.ok(orders);
    }
}
