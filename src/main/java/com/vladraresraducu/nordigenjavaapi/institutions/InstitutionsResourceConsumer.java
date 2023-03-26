package com.vladraresraducu.nordigenjavaapi.institutions;

import com.vladraresraducu.nordigenjavaapi.institutions.model.Integration;
import com.vladraresraducu.nordigenjavaapi.institutions.model.InstitutionsRequest;
import com.vladraresraducu.nordigenjavaapi.institutions.model.IntegrationRetrieve;
import com.vladraresraducu.nordigenjavaapi.token.TokenContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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

    public Integration[] getAllInstitutions(InstitutionsRequest institutionsRequest) {
        return this.webClient.get()
                .uri(
                        uriBuilder -> uriBuilder.path(LIST_ALL_AVAILABLE_INSTITUTIONS_URL)
                                .queryParam("country", institutionsRequest.getCountry())
                                .queryParam("payments_enabled", institutionsRequest.getPaymentsEnabled())
                                .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenContext.getAccessToken())
                .retrieve()
                .bodyToMono(Integration[].class)
                .block();
    }

    public IntegrationRetrieve getInstitution(String id) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path(DETAILS_ABOUT_SPECIFIC_INSTITUTIONS_URL).build(id))
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenContext.getAccessToken())
                .retrieve()
                .bodyToMono(IntegrationRetrieve.class)
                .block();
    }
}
