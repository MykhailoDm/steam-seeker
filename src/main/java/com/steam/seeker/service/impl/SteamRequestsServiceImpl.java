package com.steam.seeker.service.impl;

import com.steam.seeker.constants.CommonConstants;
import com.steam.seeker.dto.AppEntryDTO;
import com.steam.seeker.dto.AppInfoDTO;
import com.steam.seeker.dto.AppListDTO;
import com.steam.seeker.service.SteamRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

        Mono<AppListDTO> appListDTO = getMono(steamApiWebClient, uriTemplate, queryParams, new ParameterizedTypeReference<>() {});
        return appListDTO
                .flatMapMany(l -> Flux.fromIterable(l.getAppsDTO().getAppEntryDTOS()));
    }

    @Override
    public Mono<AppInfoDTO> getAppInfo(String id) {
        final String uriTemplate = String.format("/api/appdetails?appids={%s}&cc={%s}&format={%s}", CommonConstants.ID, CommonConstants.CC, CommonConstants.FORMAT);
        final Map<String, String> queryParams = Map.of(CommonConstants.ID, id, CommonConstants.CC, CommonConstants.COUNTRY_CODE, CommonConstants.FORMAT, CommonConstants.JSON);

        return getMono(steamStoreWebClient, uriTemplate, queryParams, new ParameterizedTypeReference<>() {});
    }

    private <T> Mono<T> getMono(WebClient webClient, String uriTemplate, Map<String, String> queryParams, ParameterizedTypeReference<T> typeReference) {
        return webClient.get()
                .uri(uriTemplate, queryParams)
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(r -> r.bodyToMono(typeReference));
    }

}
