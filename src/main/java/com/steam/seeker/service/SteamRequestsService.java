package com.steam.seeker.service;

import com.steam.seeker.dto.AppEntryDTO;
import reactor.core.publisher.Flux;

public interface SteamRequestsService {

    Flux<AppEntryDTO> getAppEntryInfo();
}
