package com.example.az.repository;

import com.example.az.model.ABTransaction;
import com.example.az.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
