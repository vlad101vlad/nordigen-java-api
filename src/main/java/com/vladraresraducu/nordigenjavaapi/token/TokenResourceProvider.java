package com.vladraresraducu.nordigenjavaapi.token;

import com.vladraresraducu.nordigenjavaapi.token.model.JWTObtainPairRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.JWTRefreshRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTObtain;
import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTRefresh;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class TokenResourceProvider {
    private final String NEW_TOKEN_URL = "/api/v2/token/new/";
    private final String REFRESH_TOKEN_URL = "/api/v2/token/refresh/";
    private WebClient webClient;

    public TokenResourceProvider(WebClient webClient) {
        this.webClient = webClient;
    }


    public SpectacularJWTObtain getNewToken(JWTObtainPairRequest jwtObtainPairRequest) {
        return this.webClient.post()
                .uri(NEW_TOKEN_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(jwtObtainPairRequest), JWTObtainPairRequest.class)
                .retrieve()
                .bodyToMono(SpectacularJWTObtain.class)
                .block();
    }

    public SpectacularJWTRefresh refreshToken(JWTRefreshRequest jwtRefreshRequest) {
        return this.webClient.post()
                .uri(REFRESH_TOKEN_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(jwtRefreshRequest), JWTRefreshRequest.class)
                .retrieve()
                .bodyToMono(SpectacularJWTRefresh.class)
                .block();
    }
}
