package com.example.az.repository;

import com.example.az.model.ABTransaction;
import com.example.az.model.ACTransaction;
import com.example.az.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ACTransactionRepository extends JpaRepository<ACTransaction, Long> {

    List<ACTransaction> findByCreatedAtBetween(Instant from, Instant to);
}
