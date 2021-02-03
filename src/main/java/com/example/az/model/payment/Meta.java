package com.example.az.model.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    private long consumerID;
    private String consumerMAC;

    @JsonProperty("consumer_id")
    public long getConsumerID() { return consumerID; }
    @JsonProperty("consumer_id")
    public void setConsumerID(long value) { this.consumerID = value; }

    @JsonProperty("consumer_mac")
    public String getConsumerMAC() { return consumerMAC; }
    @JsonProperty("consumer_mac")
    public void setConsumerMAC(String value) { this.consumerMAC = value; }
}