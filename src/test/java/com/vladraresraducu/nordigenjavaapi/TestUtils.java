package com.vladraresraducu.nordigenjavaapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestUtils {
    @Value("${token.secret.id}")
    private String secretId;
    @Value("${token.secret.key}")
    private String secretKey;

    public String getSecretId() {
        return secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
