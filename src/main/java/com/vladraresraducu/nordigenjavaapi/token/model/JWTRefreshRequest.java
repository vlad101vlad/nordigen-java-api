package com.vladraresraducu.nordigenjavaapi.token.model;

import java.io.Serializable;

public class JWTRefreshRequest implements Serializable {
    private final String refresh;

    public JWTRefreshRequest(String refresh) {
        this.refresh = refresh;
    }

    public String getRefresh() {
        return refresh;
    }
}
