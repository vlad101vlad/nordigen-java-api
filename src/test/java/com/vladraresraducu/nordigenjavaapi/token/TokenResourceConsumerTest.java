package com.vladraresraducu.nordigenjavaapi.token;

import com.vladraresraducu.nordigenjavaapi.token.model.JWTObtainPairRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.JWTRefreshRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TokenResourceConsumerTest {
    @Value("${token.secret.id}")
    private String secretId;
    @Value("${token.secret.key}")
    private String secretKey;

    @Autowired
    private TokenResourceConsumer tokenResourceConsumer;

    @Test
    public void testGetToken_shouldReturnToken() {
        var token = tokenResourceConsumer.getToken(jwtObtainPairRequest());
        assertNotNull(token);
        assertTrue(token.getAccess_expires() > 0);
    }

    @Test
    public void testGetRefreshToken_shouldRefreshToken() {
        var token = tokenResourceConsumer.getToken(jwtObtainPairRequest());
        assertNotNull(token);
        var refreshToken = tokenResourceConsumer.getRefreshToken(new JWTRefreshRequest(token.getRefresh()));
        assertNotNull(refreshToken);
        assertTrue(refreshToken.getAccess_expires() > 0);
    }

    private JWTObtainPairRequest jwtObtainPairRequest() {
        return new JWTObtainPairRequest(secretId, secretKey);
    }
}
