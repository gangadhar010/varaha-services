package com.varaha.web.controller;

import com.varaha.common.model.Payment;
import com.varaha.common.service.PaymentService;
import com.varaha.web.dto.ChargeRequest;
import com.varaha.web.dto.ChargeResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/charge")
    public ResponseEntity<ChargeResponse> chargePayment(@Valid @RequestBody ChargeRequest request) {
        Payment payment = paymentService.chargePayment(
            request.getOrderId(),
            request.getPaymentMethod(),
            request.getPaymentProvider(),
            request.getReturnUrl()
        );

        ChargeResponse response = new ChargeResponse();
        response.setPayment(payment);
        // In a real scenario, redirectUrl would come from the payment gateway
        response.setRedirectUrl(null); 
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentStatus(@PathVariable String paymentId) {
        Payment payment = paymentService.getPaymentStatus(paymentId);
        // Handle null case for 404
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/webhook/{provider}")
    public ResponseEntity<Void> handleWebhook(@PathVariable String provider, @RequestBody Map<String, Object> payload) {
        paymentService.handleWebhook(provider, payload);
        return ResponseEntity.ok().build();
    }
}
