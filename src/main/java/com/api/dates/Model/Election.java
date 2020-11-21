package com.api.dates.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Election {

    @JsonProperty("id")
    private String id;
    @JsonProperty("pav")
    private String pav;
    @JsonProperty("rink_data")
    private String rinkData;

    public Election() {
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("pav")
    public String getPav() {
        return pav;
    }

    @JsonProperty("pav")
    public void setPav(String pav) {
        this.pav = pav;
    }

    @JsonProperty("rink_data")
    public String getRinkData() {
        return rinkData;
    }

    @JsonProperty("rink_data")
    public void setRinkData(String rinkData) {
        this.rinkData = rinkData;
    }

}
