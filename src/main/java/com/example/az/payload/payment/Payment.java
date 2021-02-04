package com.example.az.payload.payment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
    private String txRef;
    private String amount;
    private String currency;
    private String redirectURL;
    private String paymentOptions;

    @JsonProperty("tx_ref")
    public String getTxRef() { return txRef; }
    @JsonProperty("tx_ref")
    public void setTxRef(String value) { this.txRef = value; }

    @JsonProperty("amount")
    public String getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(String value) { this.amount = value; }

    @JsonProperty("currency")
    public String getCurrency() { return currency; }
    @JsonProperty("currency")
    public void setCurrency(String value) { this.currency = value; }

    @JsonProperty("redirect_url")
    public String getRedirectURL() { return redirectURL; }
    @JsonProperty("redirect_url")
    public void setRedirectURL(String value) { this.redirectURL = value; }

    @JsonProperty("payment_options")
    public String getPaymentOptions() { return paymentOptions; }
    @JsonProperty("payment_options")
    public void setPaymentOptions(String value) { this.paymentOptions = value; }
}

