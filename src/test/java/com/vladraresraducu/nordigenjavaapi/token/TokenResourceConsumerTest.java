package com.vladraresraducu.nordigenjavaapi.token;

import com.vladraresraducu.nordigenjavaapi.token.model.JWTObtainPairRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.JWTRefreshRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTObtain;
import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTRefresh;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TokenResourceConsumerTest {
    @Value("${token.secret.id}")
    private String secretId;
    @Value("${token.secret.key}")
    private String secretKey;

    @Autowired
    private TokenResourceConsumer tokenResourceConsumer;


    @Test
    public void testV2TokenNew_shouldReturnJWT() {
        SpectacularJWTObtain spectacularJWTObtain = tokenResourceConsumer.getNewToken(getJwtObtainPairRequest());
        SpectacularJWTRefresh spectacularJWTRefresh = tokenResourceConsumer.refreshToken(new JWTRefreshRequest(spectacularJWTObtain.getRefresh()));

        assertNotNull(spectacularJWTObtain);
        assertNotNull(spectacularJWTRefresh);
    }

    private JWTObtainPairRequest getJwtObtainPairRequest() {
        System.out.println(this.secretId);
        return new JWTObtainPairRequest(this.secretId, this.secretKey);
    }
}
