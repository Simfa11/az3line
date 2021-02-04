package com.example.az.payload;

import com.example.az.model.ABTransaction;
import com.example.az.model.ACTransaction;

import java.util.List;

public class TranReportResponse {

    private Long totalSum;
    private int totalTransactions;
    private int abTotal;
    private int acTotal;
    private List<ABTransaction> abTransactions;
    private List<ACTransaction> acTransactions;

    public Long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Long totalSum) {
        this.totalSum = totalSum;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public int getAbTotal() {
        return abTotal;
    }

    public void setAbTotal(int abTotal) {
        this.abTotal = abTotal;
    }

    public int getAcTotal() {
        return acTotal;
    }

    public void setAcTotal(int acTotal) {
        this.acTotal = acTotal;
    }

    public List<ABTransaction> getAbTransactions() {
        return abTransactions;
    }

    public void setAbTransactions(List<ABTransaction> abTransactions) {
        this.abTransactions = abTransactions;
    }

    public List<ACTransaction> getAcTransactions() {
        return acTransactions;
    }

    public void setAcTransactions(List<ACTransaction> acTransactions) {
        this.acTransactions = acTransactions;
    }
}
