package com.steam.seeker.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.steam.seeker.BaseAbstractTest;
import com.steam.seeker.test_util.RandomUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppEntryDtoTest extends BaseAbstractTest {

    @Test
    void appEntryDtoTest() throws JsonProcessingException {
        final Long appId = RandomUtil.randomLongId();
        final String name = RandomUtil.randomStringUUID();
        AppEntryDTO appEntryDTO = new AppEntryDTO(appId, name);
        assertEquals(appId, appEntryDTO.getAppId());
        assertEquals(name, appEntryDTO.getName());
        assertEquals(String.format("AppEntryDTO{appId=%s, name='%s'}", appId, name), appEntryDTO.toString());

        final String appEntryString = String.format("{\"appid\":%s,\"name\":\"%s\"}", appId, name);
        final AppEntryDTO deserialized = objectMapper.readValue(appEntryString, AppEntryDTO.class);
        assertEquals(appEntryDTO.getAppId(), deserialized.getAppId());
        assertEquals(appEntryDTO.getName(), deserialized.getName());

        final String entryString = String.format("\"{\\\"appid\\\":%s,\\\"name\\\":\\\"%s\\\"}\"", appId, name);
        final String serialized = objectMapper.writeValueAsString(appEntryString);
        assertEquals(entryString, serialized);

        final Long newAppId = RandomUtil.randomLongId();
        final String newName = RandomUtil.randomStringUUID();
        appEntryDTO.setAppId(newAppId);
        appEntryDTO.setName(newName);
        assertEquals(newAppId, appEntryDTO.getAppId());
        assertEquals(newName, appEntryDTO.getName());
        assertEquals(String.format("AppEntryDTO{appId=%s, name='%s'}", newAppId, newName), appEntryDTO.toString());

    }

}