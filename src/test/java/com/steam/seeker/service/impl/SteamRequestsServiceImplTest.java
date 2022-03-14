package com.steam.seeker.service.impl;

import com.steam.seeker.BaseAbstractTest;
import com.steam.seeker.dto.AppEntryDTO;
import com.steam.seeker.dto.AppInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SteamRequestsServiceImplTest extends BaseAbstractTest {

    @Autowired
    private SteamRequestsServiceImpl requestsService;

    @Test
    void getAppEntryInfo() {
        final Flux<AppEntryDTO> appEntryInfo = requestsService.getAppEntryInfo();

        assertNotNull(appEntryInfo);
        StepVerifier.create(appEntryInfo)
                .assertNext(a -> {
                    assertNotNull(a.getName());
                    assertNotNull(a.getAppId());
                })
                .thenCancel()
                .verify();
    }

    @Test
    void getAppInfo() {
        AppEntryDTO appEntryDTO = requestsService.getAppEntryInfo()
                .blockFirst();
        assertNotNull(appEntryDTO);
        assertNotNull(appEntryDTO.getAppId());

        Long appId = appEntryDTO.getAppId();
        Mono<AppInfoDTO> appInfo = requestsService.getAppInfo("57690");
        StepVerifier.create(appInfo)
                .assertNext(a -> {
                    assertTrue(a.getSuccess());
                    assertNotNull(a.getData());
                }).verifyComplete();
    }
}