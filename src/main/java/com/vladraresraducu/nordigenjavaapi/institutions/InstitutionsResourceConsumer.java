package com.vladraresraducu.nordigenjavaapi.institutions;

import com.vladraresraducu.nordigenjavaapi.institutions.model.Integration;
import com.vladraresraducu.nordigenjavaapi.institutions.model.InstitutionsRequest;
import com.vladraresraducu.nordigenjavaapi.token.TokenContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class InstitutionsResourceConsumer {
    private final String LIST_ALL_AVAILABLE_INSTITUTIONS_URL = "/api/v2/institutions/";
    private final String DETAILS_ABOUT_SPECIFIC_INSTITUTIONS_URL = "/api/v2/institutions/{id}/";

    private final WebClient webClient;
    private final TokenContext tokenContext;

    public InstitutionsResourceConsumer(WebClient webClient, TokenContext tokenContext) {
        this.webClient = webClient;
        this.tokenContext = tokenContext;
    }

    public Integration getAllInstitutions(InstitutionsRequest institutionsRequest) {
        return this.webClient.post()
                .uri(LIST_ALL_AVAILABLE_INSTITUTIONS_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(institutionsRequest), InstitutionsRequest.class)
                .retrieve()
                .bodyToMono(Integration.class)
                .block();
    }
}
