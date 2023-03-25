package com.vladraresraducu.nordigenjavaapi.institutions.model;

public enum Country {
    GB("GB"),
    NO("NO"),
    SE("SE"),
    FI("FI"),
    DK("DK"),
    EE("EE"),
    LV("LV"),
    LT("LT"),
    NL("NL"),
    CZ("CZ"),
    ES("ES"),
    PL("PL"),
    BE("BE"),
    DE("DE"),
    AT("AT"),
    BG("BG"),
    HR("HR"),
    CY("CY"),
    FR("FR"),
    GR("GR"),
    HU("HU"),
    IS("IS"),
    IE("IE"),
    IT("IT"),
    LI("LI"),
    LU("LU"),
    MT("MT"),
    PT("PT"),
    RO("RO"),
    SK("SK"),
    SI("SI");


    private String countryCode;

    Country(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
