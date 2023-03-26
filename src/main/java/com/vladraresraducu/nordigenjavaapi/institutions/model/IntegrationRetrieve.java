package com.vladraresraducu.nordigenjavaapi.institutions.model;

import com.vladraresraducu.nordigenjavaapi.enums.Country;
import org.json.JSONObject;

import java.io.Serializable;

public class IntegrationRetrieve implements Serializable {
    private String id;
    private String name;
    private String bic;
    private String transaction_total_days;
    private Country[] countries;
    private String logo;
    private JSONObject supported_payments;
    private String[] supported_features;


    public IntegrationRetrieve() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getTransaction_total_days() {
        return transaction_total_days;
    }

    public void setTransaction_total_days(String transaction_total_days) {
        this.transaction_total_days = transaction_total_days;
    }

    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public JSONObject getSupported_payments() {
        return supported_payments;
    }

    public void setSupported_payments(JSONObject supported_payments) {
        this.supported_payments = supported_payments;
    }

    public String[] getSupported_features() {
        return supported_features;
    }

    public void setSupported_features(String[] supported_features) {
        this.supported_features = supported_features;
    }
}
