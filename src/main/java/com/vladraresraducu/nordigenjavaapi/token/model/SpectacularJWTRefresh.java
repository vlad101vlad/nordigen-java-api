package com.vladraresraducu.nordigenjavaapi.token.model;

public class SpectacularJWTRefresh {
    private final String access;
    private final int access_expires;

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
