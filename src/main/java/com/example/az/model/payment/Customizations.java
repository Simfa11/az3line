package com.example.az.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customizations {
    private String title;
    private String description;
    private String logo;

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("logo")
    public String getLogo() { return logo; }
    @JsonProperty("logo")
    public void setLogo(String value) { this.logo = value; }
}
