package com.steam.seeker.service;

import com.steam.seeker.dto.AppEntryDTO;
import com.steam.seeker.dto.AppInfoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SteamRequestsService {

    Flux<AppEntryDTO> getAppEntryInfo();

    Mono<AppInfoDTO> getAppInfo(String id);
}
