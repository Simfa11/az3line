package com.example.az.api;


import com.example.az.enums.Outlet;
import com.example.az.enums.ResponseCode;
import com.example.az.enums.TranType;
import com.example.az.model.User;
import com.example.az.payload.GenericResponse;
import com.example.az.payload.TranReportResponse;
import com.example.az.payload.TranRequest;
import com.example.az.repository.UserRepository;
import com.example.az.service.TransactionService;
import com.example.az.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/az/api/v1/transactions")
public class TransactionController {

    private static Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;


    /**
     * This is for User's Balance in Wallet
     *
     * @param request
     * @return
     */
    @PostMapping("/credit")
    public ResponseEntity<?> credit(@RequestBody TranRequest request) {

        if (request.getOutlet() == null || request.getOutlet().equalsIgnoreCase(Outlet.AB.getOutlet()) || request.getOutlet().equalsIgnoreCase(Outlet.AC.getOutlet())) {
            return new ResponseEntity<>(new GenericResponse<>(ResponseCode.FAILED.getStatus(), "Invalid outlet. Valid outlets are AB and AC", null, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
        }

        if (request.getTranType() == null || request.getTranType().equalsIgnoreCase(TranType.CREDIT.getTranType()) || request.getTranType().equalsIgnoreCase(TranType.DEBIT.getTranType())) {
            return new ResponseEntity<>(new GenericResponse<>(ResponseCode.FAILED.getStatus(), "Invalid Transaction type. It should be either credit or debit", null, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
        }

        Optional<User> user = userService.findById(request.getUserId());
        if (user.isPresent()) {
            User user1 = user.get();
            if (user1.getBalance() >= request.getAmount()) {
                //deduct from user wallet
                long diff = user1.getBalance() - request.getAmount();
                User balance = userService.updateBalance(user1, diff);
                transactionService.logTransaction(user1, request);

                return new ResponseEntity<>(new GenericResponse<>(ResponseCode.SUCCESSFUL.getStatus(), "Payment made", balance, HttpStatus.OK.value()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new GenericResponse<>(ResponseCode.SUCCESSFUL.getStatus(), "Insufficient funds. Please fund your wallet", null, HttpStatus.OK.value()), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(new GenericResponse<>(ResponseCode.FAILED.getStatus(), "User not found", null, HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllTransactions(@RequestParam(name = "from", defaultValue = "") String from, @RequestParam(name = "to", defaultValue = "") String to) {
        TranReportResponse response;
        if (from.isEmpty() || to.isEmpty())
            response = transactionService.getAllTransactions();
        else {
            Instant fromDate = Instant.parse(from);
            Instant toDate = Instant.parse(to);
            response = transactionService.getTransactionsBetween(fromDate, toDate);
        }

        return new ResponseEntity<>(new GenericResponse<>(ResponseCode.SUCCESSFUL.getStatus(), "", response, HttpStatus.OK.value()), HttpStatus.OK);
    }
}
