package com.vladraresraducu.nordigenjavaapi.enums;

public enum PaymentProduct {
    T2P("T2P"),
    SCT("SCT"),
    ISCT("ISCT"),
    CBCT("CBCT"),
    BACS("BACS"),
    CHAPS("CHAPS"),
    FPS("FPS"),
    SWIFT("SWIFT"),
    BT("BT"),
    MT("MT");

    private String paymentProduct;

    PaymentProduct(String paymentProduct) {
        this.paymentProduct = paymentProduct;
    }

    public String getPaymentProduct() {
        return paymentProduct;
    }
}
