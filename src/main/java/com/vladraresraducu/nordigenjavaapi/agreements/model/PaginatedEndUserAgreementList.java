package com.vladraresraducu.nordigenjavaapi.agreements.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PaginatedEndUserAgreementList {
    @JsonProperty("count")
    private int count;

    @JsonProperty("next")
    private String next;

    @JsonProperty("previous")
    private String previous;

    @JsonProperty("results")
    private List<EndUserAgreement> results;

    public PaginatedEndUserAgreementList() {
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<EndUserAgreement> getResults() {
        return results;
    }
}
