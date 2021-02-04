package com.example.az.repository;

import com.example.az.model.ABTransaction;
import com.example.az.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public interface ABTransactionRepository extends JpaRepository<ABTransaction, Long> {

    List<ABTransaction> findByCreatedAtBetween(Instant from, Instant to);
}
