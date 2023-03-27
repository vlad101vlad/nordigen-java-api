package com.vladraresraducu.nordigenjavaapi;

import com.vladraresraducu.nordigenjavaapi.token.TokenResourceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {
    public final static String NORDIGEN_URL = "https://ob.nordigen.com";

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(NORDIGEN_URL)
                .filter(errorHandler())
                .build();
    }

    @Bean
    public TokenResourceProvider tokenResourceProvider(WebClient webClient) {
        return new TokenResourceProvider(webClient);
    }

    private ExchangeFilterFunction errorHandler() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            if (clientResponse.statusCode().is5xxServerError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new Exception(errorBody)));
            } else if (clientResponse.statusCode().is4xxClientError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new Exception(errorBody)));
            } else {
                return Mono.just(clientResponse);
            }
        });
    }
}
