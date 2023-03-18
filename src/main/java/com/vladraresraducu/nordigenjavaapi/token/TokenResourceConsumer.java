package com.vladraresraducu.nordigenjavaapi.token;

import com.vladraresraducu.nordigenjavaapi.token.model.JWTObtainPairRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.JWTRefreshRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTObtain;
import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTRefresh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenResourceConsumer {
    @Autowired
    private TokenResourceProvider tokenResourceProvider;

    public SpectacularJWTObtain getToken(JWTObtainPairRequest jwtObtainPairRequest) {
        return tokenResourceProvider.getNewToken(jwtObtainPairRequest);
    }

    public SpectacularJWTRefresh getRefreshToken(JWTRefreshRequest jwtRefreshRequest) {
        return tokenResourceProvider.refreshToken(jwtRefreshRequest);
    }
}
