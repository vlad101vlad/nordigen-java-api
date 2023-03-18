package com.vladraresraducu.nordigenjavaapi;

import com.vladraresraducu.nordigenjavaapi.token.TokenResourceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient() {
        final String NORDIGEN_URL = "https://ob.nordigen.com";
        return WebClient.builder().baseUrl(NORDIGEN_URL).build();
    }

    @Bean
    public TokenResourceProvider tokenResourceProvider(WebClient webClient) {
        return new TokenResourceProvider(webClient);
    }
}
