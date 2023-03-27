package com.vladraresraducu.nordigenjavaapi.agreements;

import com.vladraresraducu.nordigenjavaapi.agreements.model.EndUserAgreement;
import com.vladraresraducu.nordigenjavaapi.agreements.model.EndUserAgreementRequest;
import com.vladraresraducu.nordigenjavaapi.agreements.model.PaginatedEndUserAgreementList;
import com.vladraresraducu.nordigenjavaapi.token.TokenContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AgreementsResourceConsumer {

    private final WebClient webClient;
    private final TokenContext tokenContext;

    public AgreementsResourceConsumer(WebClient webClient, TokenContext tokenContext) {
        this.webClient = webClient;
        this.tokenContext = tokenContext;
    }

    public PaginatedEndUserAgreementList getEndUserAgreement() {
        return getEndUserAgreement(100, 1);
    }

    public PaginatedEndUserAgreementList getEndUserAgreement(int limit, int offset) {
        return this.webClient.get()
                .uri(
                        uriBuilder -> uriBuilder.path(AgreementsEndpoints.AGREEMENTS_GENERAL_URL)
                                .queryParam("limit", limit)
                                .queryParam("offset", offset)
                                .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenContext.getAccessToken())
                .retrieve()
                .bodyToMono(PaginatedEndUserAgreementList.class)
                .block();
    }

    public EndUserAgreement getEndUserAgreement(String uuid) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder.path(AgreementsEndpoints.AGREEMENTS_BY_ID_URL).build(uuid))
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenContext.getAccessToken())
                .retrieve()
                .bodyToMono(EndUserAgreement.class)
                .block();
    }

    public EndUserAgreement createEnduserAgreement(EndUserAgreementRequest endUserAgreementRequest) {
        return this.webClient.post()
                .uri(AgreementsEndpoints.AGREEMENTS_GENERAL_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenContext.getAccessToken())
                .body(Mono.just(endUserAgreementRequest), EndUserAgreementRequest.class)
                .retrieve()
                .bodyToMono(EndUserAgreement.class)
                .block();
    }

    public void deleteEnduserAgreement(String uuid) {
        this.webClient.delete()
                .uri(uriBuilder -> uriBuilder.path(AgreementsEndpoints.AGREEMENTS_BY_ID_URL).build(uuid))
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + tokenContext.getAccessToken())
                .retrieve().toBodilessEntity().block();
    }


    private static class AgreementsEndpoints {
        public final static String AGREEMENTS_GENERAL_URL = "/api/v2/agreements/enduser/";
        public final static String AGREEMENTS_BY_ID_URL = "/api/v2/agreements/enduser/{id}/";
        public final static String AGREEMENTS_ACCEPT_ID_URL = "/api/v2/agreements/enduser/{id}/accept/";
    }
}
