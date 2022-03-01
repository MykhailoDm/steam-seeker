package com.steam.seeker.service.impl;

import com.steam.seeker.constants.CommonConstants;
import com.steam.seeker.dto.AppEntryDTO;
import com.steam.seeker.dto.AppListDTO;
import com.steam.seeker.service.SteamRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
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
    public Flux<AppEntryDTO> getAppEntryInfo() {
        final String uriTemplate = "/ISteamApps/GetAppList/v2/?format={format}";
        final Map<String, String> queryParams = Map.of(CommonConstants.FORMAT, CommonConstants.JSON);

        return steamApiWebClient.get()
                .uri(uriTemplate, queryParams)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(r -> r.bodyToMono(AppListDTO.class))
                .flatMapMany(l -> Flux.fromIterable(l.getAppsDTO().getAppEntryDTOS()));
    }
}
