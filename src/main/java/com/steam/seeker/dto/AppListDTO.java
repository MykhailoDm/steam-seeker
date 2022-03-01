package com.steam.seeker.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AppListDTO {

    private List<AppEntryDTO> appEntryDTOS;

    @JsonCreator
    public AppListDTO() {
    }

    @JsonCreator
    public AppListDTO(@JsonProperty("applist")
                      List<AppEntryDTO> appEntryDTOS) {
        this.appEntryDTOS = appEntryDTOS;
    }

    public List<AppEntryDTO> getAppEntryDTOS() {
        return appEntryDTOS;
    }

    public void setAppEntryDTOS(List<AppEntryDTO> appEntryDTOS) {
        this.appEntryDTOS = appEntryDTOS;
    }

    @Override
    public String toString() {
        return "AppListDTO{" +
                "appEntryDTOS=" + appEntryDTOS +
                '}';
    }
}
