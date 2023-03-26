package com.vladraresraducu.nordigenjavaapi.institutions.model;

import com.vladraresraducu.nordigenjavaapi.enums.PaymentProduct;
import com.vladraresraducu.nordigenjavaapi.enums.PaymentType;

import java.io.Serializable;
import java.util.Map;

public class SupportedPayments implements Serializable {
    private Map<PaymentType, PaymentProduct[]> payments;

    public SupportedPayments() {
    }

    public SupportedPayments(Map<PaymentType, PaymentProduct[]> payments) {
        this.payments = payments;
    }

    public Map<PaymentType, PaymentProduct[]> getPayments() {
        return payments;
    }

    public void setPayments(Map<PaymentType, PaymentProduct[]> payments) {
        this.payments = payments;
    }
}
