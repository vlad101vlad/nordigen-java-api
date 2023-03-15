package com.vladraresraducu.nordigenjavaapi.token.model;

import java.io.Serializable;

public class JWTObtainPairRequest implements Serializable {
    private final String secret_id;
    private final String secret_key;

    public JWTObtainPairRequest(String secretId, String secretKey) {
        this.secret_id = secretId;
        this.secret_key = secretKey;
    }

    public String getSecret_id() {
        return secret_id;
    }

    public String getSecret_key() {
        return secret_key;
    }
}
