package com.example.az.service;

import com.example.az.model.User;
import com.example.az.payload.TranReportResponse;
import com.example.az.payload.TranRequest;

import java.time.Instant;


public interface TransactionService {


    void logTransaction(User user, TranRequest request);


    TranReportResponse getAllTransactions();

    TranReportResponse getTransactionsBetween(Instant fromDate, Instant toDate);

}
