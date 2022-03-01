package com.steam.seeker.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AppListDTO {

    private AppsDTO appsDTO;

    @JsonCreator
    public AppListDTO() {
    }

    @JsonCreator
    public AppListDTO(@JsonProperty("applist") AppsDTO appsDTO) {
        this.appsDTO = appsDTO;
    }

    public AppsDTO getAppsDTO() {
        return appsDTO;
    }

    public void setAppsDTO(AppsDTO appsDTO) {
        this.appsDTO = appsDTO;
    }

    @Override
    public String toString() {
        return "AppListDTO{" +
                "appsDTO=" + appsDTO +
                '}';
    }

    public static class AppsDTO {
        private List<AppEntryDTO> appEntryDTOS;

        @JsonCreator
        public AppsDTO() {
        }

        @JsonCreator
        public AppsDTO(@JsonProperty("apps")
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
            return "AppsDTO{" +
                    "appEntryDTOS=" + appEntryDTOS +
                    '}';
        }
    }
}
