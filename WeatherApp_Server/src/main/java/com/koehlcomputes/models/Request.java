package com.koehlcomputes.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

    @JsonProperty(value = "query")
    private String query;
    @JsonProperty(value = "units")
    private String units;

    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public String getUnits() {
        return units;
    }
    public void setUnits(){
        this.units = units;
    }

}

