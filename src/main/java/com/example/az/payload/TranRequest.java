package com.example.az.payload;

public class TranRequest {

    private Long userId;
    private String outlet;
    private long amount;

    private String tranId;

    private String description = "";

    private String tranType;

    public TranRequest(Long userId, String outlet, long amount, String tranId, String description) {
        this.userId = userId;
        this.outlet = outlet;
        this.amount = amount;
        this.tranId = tranId;
        this.description = description;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TranRequest{" +
                "userId=" + userId +
                ", outlet='" + outlet + '\'' +
                ", amount=" + amount +
                ", tranId='" + tranId + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
