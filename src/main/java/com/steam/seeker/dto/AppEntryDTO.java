package com.steam.seeker.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AppEntryDTO {

    private Long appId;
    private String name;

    @JsonCreator
    public AppEntryDTO() {
    }

    @JsonCreator
    public AppEntryDTO(@JsonProperty("appid")
                       Long appId,
                       @JsonProperty("name")
                       String name) {
        this.appId = appId;
        this.name = name;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AppEntryDTO{" +
                "appId=" + appId +
                ", name='" + name + '\'' +
                '}';
    }
}
