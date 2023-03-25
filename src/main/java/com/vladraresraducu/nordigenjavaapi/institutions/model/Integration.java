package com.vladraresraducu.nordigenjavaapi.institutions.model;

import java.io.Serializable;
import java.util.List;

public class Integration implements Serializable {
    private String id;
    private String name;
    private String bic;
    private String transaction_total_days;
    private List<Country> countryList;
    private String logo;

    public Integration() {
    }

    public Integration(String id, String name, String bic, String transaction_total_days, List<Country> countryList, String logo) {
        this.id = id;
        this.name = name;
        this.bic = bic;
        this.transaction_total_days = transaction_total_days;
        this.countryList = countryList;
        this.logo = logo;
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

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
