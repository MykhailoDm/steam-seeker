package com.steam.seeker.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steam.seeker.test_util.RandomUtil;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppListDTOTest {

    @Test
    void testAppListDTO() throws JsonProcessingException {
        AppEntryDTO appEntryDTO1 = new AppEntryDTO(RandomUtil.randomLongId(), RandomUtil.randomStringUUID());
        AppEntryDTO appEntryDTO2 = new AppEntryDTO(RandomUtil.randomLongId(), RandomUtil.randomStringUUID());
        List<AppEntryDTO> appEntryDTOs = List.of(appEntryDTO1, appEntryDTO2);

        AppListDTO appListDTO = new AppListDTO(new AppListDTO.AppsDTO(appEntryDTOs));
        assertEquals(appEntryDTOs, appListDTO.getAppsDTO().getAppEntryDTOS());
        assertEquals("AppListDTO{appsDTO=AppsDTO{appEntryDTOS=[AppEntryDTO{appId=" + appEntryDTO1.getAppId() + ", name='" + appEntryDTO1.getName() + "'}, AppEntryDTO{appId=" + appEntryDTO2.getAppId() + ", name='" + appEntryDTO2.getName() + "'}]}}", appListDTO.toString());

        String jsonString = String.format("{\"applist\":{\"apps\":[{\"appid\":%s,\"name\":\"%s\"}]}}", appEntryDTO1.getAppId(), appEntryDTO1.getName());
        ObjectMapper objectMapper = new ObjectMapper();
        AppListDTO deserialized = objectMapper.readValue(jsonString, AppListDTO.class);
        AppEntryDTO actual = deserialized.getAppsDTO().getAppEntryDTOS().stream().findFirst().orElseThrow();
        assertEquals(appEntryDTO1.getAppId(), actual.getAppId());
        assertEquals(appEntryDTO1.getName(), actual.getName());

        Long newAppId = RandomUtil.randomLongId();
        String newName = RandomUtil.randomStringUUID();
        AppEntryDTO newAppEntryDTO = new AppEntryDTO(newAppId, newName);
        List<AppEntryDTO> newAppEntryDTOS = Collections.singletonList(newAppEntryDTO);
        appListDTO.getAppsDTO().setAppEntryDTOS(newAppEntryDTOS);

        AppEntryDTO actualAppEntry = appListDTO.getAppsDTO().getAppEntryDTOS().stream().findFirst().orElseThrow();
        assertEquals(newAppEntryDTO.getAppId(), actualAppEntry.getAppId());
        assertEquals(newAppEntryDTO.getName(), actualAppEntry.getName());
    }

}