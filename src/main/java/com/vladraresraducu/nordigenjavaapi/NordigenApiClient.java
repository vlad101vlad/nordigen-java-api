package com.vladraresraducu.nordigenjavaapi;

import com.vladraresraducu.nordigenjavaapi.institutions.InstitutionsResourceConsumer;
import com.vladraresraducu.nordigenjavaapi.token.TokenContext;
import com.vladraresraducu.nordigenjavaapi.token.TokenResourceConsumer;
import com.vladraresraducu.nordigenjavaapi.token.model.JWTObtainPairRequest;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class NordigenApiClient {
    private String secretId;
    private String secretKey;
    @Autowired
    private TokenContext tokenContext;
    @Autowired
    private TokenResourceConsumer tokenResourceConsumer;
    @Autowired
    public InstitutionsResourceConsumer institutionsResourceConsumer;

    public NordigenApiClient(@Value("${token.secret.id}") String secretId,
                             @Value("${token.secret.key}") String secretKey) {
        this.secretId = secretId;
        this.secretKey = secretKey;
    }

    @PostConstruct
    private void aquireToken() {
        var token = tokenResourceConsumer.getToken(createJWTObtainPairRequest());
        tokenContext.setSpectacularJWTObtain(token);
    }

    private JWTObtainPairRequest createJWTObtainPairRequest() {
        return new JWTObtainPairRequest(secretId, secretKey);
    }
}
