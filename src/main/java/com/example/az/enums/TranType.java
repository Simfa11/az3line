package com.example.az.enums;

public enum  TranType {

    CREDIT("credit"), DEBIT("debit");

    TranType(String tranType) {
        this.tranType = tranType;
    }

    private String tranType;

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
}
