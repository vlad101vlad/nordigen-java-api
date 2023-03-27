package com.vladraresraducu.nordigenjavaapi.agreements.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

public class EndUserAgreementRequest {
    @JsonProperty("institution_id")
    private String institutionId;

    @JsonProperty("max_historical_days")
    private int maxHistoricalDays = 90;

    @JsonProperty("access_valid_for_days")
    private int accessValidForDays = 90;

    @JsonProperty("access_scope")
    private List<String> accessScope = List.of("balances", "details", "transactions");

    public EndUserAgreementRequest() {
    }

    public EndUserAgreementRequest(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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
}
