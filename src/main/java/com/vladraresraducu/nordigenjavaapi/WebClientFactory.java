package com.vladraresraducu.nordigenjavaapi;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientFactory {

    private WebClient webClient;

    public WebClientFactory(String baseUrl, String token) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(new WebClientInterceptor(token))
                .build();
    }

    public WebClient getWebClient() {
        return webClient;
    }
}
