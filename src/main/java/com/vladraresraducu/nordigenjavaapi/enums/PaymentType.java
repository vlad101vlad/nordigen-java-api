package com.vladraresraducu.nordigenjavaapi.enums;

public enum PaymentType {
    SINGLE_PAYMENT("single-payment"),
    BULK_PAYMENT("bulk-payment"),
    PERIODIC_PAYMENT("periodic-payment");

    private final String value;

    PaymentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PaymentType fromValue(String value) {
        for (PaymentType paymentType : PaymentType.values()) {
            if (paymentType.value.equals(value)) {
                return paymentType;
            }
        }
        throw new IllegalArgumentException("Invalid payment type: " + value);
    }
}
