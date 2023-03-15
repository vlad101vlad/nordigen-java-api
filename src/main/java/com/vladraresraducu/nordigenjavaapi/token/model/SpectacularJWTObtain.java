package com.vladraresraducu.nordigenjavaapi.token.model;

public class SpectacularJWTObtain {
    private final String access;
    private final int access_expires;
    private final String refresh;
    private final int refresh_expires;

    public SpectacularJWTObtain(String access, int accessExpires, String refresh, int refreshExpires) {
        this.access = access;
        this.access_expires = accessExpires;
        this.refresh = refresh;
        this.refresh_expires = refreshExpires;
    }

    public String getAccess() {
        return access;
    }

    public int getAccess_expires() {
        return access_expires;
    }

    public String getRefresh() {
        return refresh;
    }

    public int getRefresh_expires() {
        return refresh_expires;
    }
}
