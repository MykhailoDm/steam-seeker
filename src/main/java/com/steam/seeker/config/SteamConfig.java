package com.steam.seeker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SteamConfig {

    @Value("${steam.api.base.url}")
    private String steamApiBaseUrl;

    @Value("${steam.store.base.url}")
    private String steamStoreBaseUrl;

    @Bean(name = "steamApiWebClient")
    public WebClient steamApiWebClient() {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();

        return WebClient.builder()
                .baseUrl(steamApiBaseUrl)
                .exchangeStrategies(strategies)
                .build();
    }

    @Bean(name = "steamStoreWebClient")
    public WebClient steamStoreWebClient() {
        return WebClient.create(steamStoreBaseUrl);
    }
}
