package com.varaha.web.dto;

import com.varaha.common.model.Payment;

public class ChargeResponse {

    private Payment payment;
    private String redirectUrl;

    // Getters and Setters

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
