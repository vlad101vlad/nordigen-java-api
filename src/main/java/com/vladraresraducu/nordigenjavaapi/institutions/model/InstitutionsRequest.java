package com.vladraresraducu.nordigenjavaapi.institutions.model;

import java.io.Serializable;

public class InstitutionsRequest implements Serializable {
    private Country country;
    private String payments_enabled;

    public InstitutionsRequest(Country country, boolean payments_enabled) {
        this.country = country;
        this.payments_enabled = String.valueOf(payments_enabled);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPaymentsEnabled() {
        return payments_enabled;
    }

    public void setPaymentsEnabled(String payments_enabled) {
        this.payments_enabled = payments_enabled;
    }
}
