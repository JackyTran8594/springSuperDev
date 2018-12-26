package com.wsplanning.webapp.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class colorPickerDTO {
    
    @JsonProperty("username")
    public String username;

    @JsonProperty("colorCode")
    public String colorCode;

    @JsonProperty("siteId")
    public String siteId;

}