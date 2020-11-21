package com.api.dates.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Election  implements Comparable<Election>{

    @JsonProperty("id")
    private String id;
    @JsonProperty("pav")
    private String pav;
    @JsonProperty("rink_data")
    private String rinkData;

    private DateFormat f = new SimpleDateFormat("yyyy-MM-dd");

    public Election() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPav() {
        return pav;
    }

    public void setPav(String pav) {
        this.pav = pav;
    }

    public String getRinkData() {
        return rinkData;
    }

    public void setRinkData(String rinkData) {
        this.rinkData = rinkData;
    }

    //For Sorting
    @Override
    public int compareTo(Election o) {
        try {
            return f.parse(this.getRinkData()).compareTo(f.parse(o.getRinkData()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
