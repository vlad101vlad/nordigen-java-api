package com.vladraresraducu.nordigenjavaapi.token;

import com.vladraresraducu.nordigenjavaapi.token.model.JWTObtainPairRequest;
import com.vladraresraducu.nordigenjavaapi.token.model.SpectacularJWTObtain;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TokenResourceConsumer {
    private final String NEW_TOKEN_URL = "/api/v2/token/new/";
    private final WebClient webClient;

    public TokenResourceConsumer(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://ob.nordigen.com")
                .build();
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
}
