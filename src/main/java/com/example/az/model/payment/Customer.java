package com.example.az.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    private String email;
    private String phonenumber;
    private String name;

    @JsonProperty("email")
    public String getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(String value) { this.email = value; }

    @JsonProperty("phonenumber")
    public String getPhonenumber() { return phonenumber; }
    @JsonProperty("phonenumber")
    public void setPhonenumber(String value) { this.phonenumber = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }
}