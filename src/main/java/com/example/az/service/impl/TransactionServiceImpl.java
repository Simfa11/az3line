package com.example.az.service.impl;

import com.example.az.enums.Outlet;
import com.example.az.enums.TranType;
import com.example.az.model.ABTransaction;
import com.example.az.model.ACTransaction;
import com.example.az.model.User;
import com.example.az.payload.TranReportResponse;
import com.example.az.payload.TranRequest;
import com.example.az.repository.ABTransactionRepository;
import com.example.az.repository.ACTransactionRepository;
import com.example.az.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    ABTransactionRepository abRepo;

    @Autowired
    ACTransactionRepository acRepo;


    public ABTransaction storeABTransaction(User user, TranRequest request) {
        ABTransaction abTransaction = new ABTransaction();
        abTransaction.setAmount(request.getAmount());
        abTransaction.setTranType(request.getTranType());
        abTransaction.setOutlet(request.getOutlet());
        abTransaction.setDescription(request.getDescription());
        return abRepo.save(abTransaction);
    }


    public ACTransaction storeACTransaction(User user, TranRequest request) {
        ACTransaction acTransaction = new ACTransaction();
        acTransaction.setAmount(request.getAmount());
        acTransaction.setTranType(request.getTranType());
        acTransaction.setOutlet(request.getOutlet());
        acTransaction.setDescription(request.getDescription());
        return acRepo.save(acTransaction);
    }

    @Override
    public void logTransaction(User user, TranRequest request) {
        if (request.getOutlet().equalsIgnoreCase(Outlet.AB.getOutlet()))
            storeABTransaction(user, request);
        else
            storeACTransaction(user, request);
    }

    @Override
    public TranReportResponse getAllTransactions() {
        List<ABTransaction> abTransactions = abRepo.findAll();
        List<ACTransaction> acTransactions = acRepo.findAll();



        TranReportResponse response = getTranReportResponse(abTransactions, acTransactions);
        return response;
    }


    private TranReportResponse getTranReportResponse(List<ABTransaction> abTransactions, List<ACTransaction> acTransactions) {
        long abSum = abTransactions.stream()
                .mapToInt(e -> Math.toIntExact(e.getAmount()))
                .sum();

        long acSum = acTransactions.stream()
                .mapToInt(e -> Math.toIntExact(e.getAmount()))
                .sum();
        TranReportResponse response = new TranReportResponse();
        response.setAbTransactions(abTransactions);
        response.setAcTransactions(acTransactions);
        response.setAbTotal(abTransactions.size());
        response.setAcTotal(acTransactions.size());
        response.setTotalSum(abSum + acSum);
        return response;
    }

    @Override
    public TranReportResponse getTransactionsBetween(Instant fromDate, Instant toDate) {
        List<ABTransaction> abTransactions = abRepo.findByCreatedAtBetween(fromDate, toDate);
        List<ACTransaction> acTransactions = acRepo.findByCreatedAtBetween(fromDate, toDate);

        return getTranReportResponse(abTransactions, acTransactions);
    }
}
