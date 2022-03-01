package com.steam.seeker.service.impl;

import com.steam.seeker.BaseAbstractTest;
import com.steam.seeker.dto.AppEntryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SteamRequestsServiceImplTest extends BaseAbstractTest {

    @Autowired
    private SteamRequestsServiceImpl requestsService;

    @Test
    void getAppEntryInfo() {
        final Flux<AppEntryDTO> appEntryInfo = requestsService.getAppEntryInfo();

        assertNotNull(appEntryInfo);
        System.out.println(appEntryInfo.blockFirst());
    }
}