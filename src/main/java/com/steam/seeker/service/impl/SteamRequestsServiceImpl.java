package com.steam.seeker.service.impl;

import com.steam.seeker.dto.AppEntryDTO;
import com.steam.seeker.service.SteamRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class SteamRequestsServiceImpl implements SteamRequestsService {

    private WebClient steamApiWebClient;
    private WebClient steamStoreWebClient;

    public SteamRequestsServiceImpl(@Autowired
                                    @Qualifier("steamApiWebClient")
                                    WebClient steamApiWebClient,
                                    @Autowired
                                    @Qualifier("steamStoreWebClient")
                                    WebClient steamStoreWebClient) {
        this.steamApiWebClient = steamApiWebClient;
        this.steamStoreWebClient = steamStoreWebClient;
    }

    @Override
    public Flux<AppEntryDTO> get() {
        return null;
    }
}
