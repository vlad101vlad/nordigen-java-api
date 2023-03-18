package com.vladraresraducu.nordigenjavaapi;

import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;


public class WebClientInterceptor implements ExchangeFilterFunction {
    private final String token;

    public WebClientInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Mono<ClientResponse> filter(ClientRequest request, ExchangeFunction next) {
        HttpHeaders headers = request.headers();
        headers.setBearerAuth(token);
        return next.exchange(request);
    }
}
