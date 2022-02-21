package com.steam.seeker.config;

import com.steam.seeker.BaseAbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;

class SteamConfigTest extends BaseAbstractTest {

    @Autowired
    @Qualifier("steamApiWebClient")
    private WebClient steamApiWebClient;

    @Autowired
    @Qualifier("steamStoreWebClient")
    private WebClient steamStoreWebClient;

    @Test
    void steamApiWebClient() {
        assertNotNull(steamApiWebClient);
    }

    @Test
    void steamStoreWebClient() {
        assertNotNull(steamStoreWebClient);
    }
}