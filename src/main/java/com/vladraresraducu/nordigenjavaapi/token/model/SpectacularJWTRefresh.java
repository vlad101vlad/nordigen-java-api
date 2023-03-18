package com.vladraresraducu.nordigenjavaapi.token.model;

import java.io.Serializable;

public class SpectacularJWTRefresh implements Serializable {
    private String access;
    private int access_expires;

    public SpectacularJWTRefresh() {
    }

    public SpectacularJWTRefresh(String access, int access_expires) {
        this.access = access;
        this.access_expires = access_expires;
    }

    public String getAccess() {
        return access;
    }

    public int getAccess_expires() {
        return access_expires;
    }
}
