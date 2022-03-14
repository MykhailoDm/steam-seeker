package com.steam.seeker.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AppInfoDTO {

    private Boolean success;
    private Data data;

    @JsonCreator
    @JsonIgnoreProperties(ignoreUnknown = true)
    public AppInfoDTO() {
    }

    @JsonCreator
    @JsonIgnoreProperties(ignoreUnknown = true)
    public AppInfoDTO(@JsonProperty("success")
                           Boolean success,
                      @JsonProperty("data")
                           Data data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private static class Data {
        @JsonCreator
        @JsonIgnoreProperties(ignoreUnknown = true)
        public Data() {
        }
    }
}
