package com.vladraresraducu.nordigenjavaapi.agreements.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EndUserAgreement {
    @JsonProperty("id")
    private String id;

    @JsonProperty("created")
    private String created;

    @JsonProperty("institution_id")
    private String institutionId;

    @JsonProperty("max_historical_days")
    private int maxHistoricalDays = 90;

    @JsonProperty("access_valid_for_days")
    private int accessValidForDays = 90;

    @JsonProperty("access_scope")
    private List<String> accessScope = List.of("balances", "details", "transactions");

    @JsonProperty("accepted")
    private String accepted;

    public EndUserAgreement() {
    }

    public EndUserAgreement(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public int getMaxHistoricalDays() {
        return maxHistoricalDays;
    }

    public void setMaxHistoricalDays(int maxHistoricalDays) {
        this.maxHistoricalDays = maxHistoricalDays;
    }

    public int getAccessValidForDays() {
        return accessValidForDays;
    }

    public void setAccessValidForDays(int accessValidForDays) {
        this.accessValidForDays = accessValidForDays;
    }

    public List<String> getAccessScope() {
        return accessScope;
    }

    public void setAccessScope(List<String> accessScope) {
        this.accessScope = accessScope;
    }

    public String getAccepted() {
        return accepted;
    }
}
