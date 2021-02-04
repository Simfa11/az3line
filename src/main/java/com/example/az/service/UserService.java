package com.example.az.service;

import com.example.az.model.User;
import com.example.az.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);

    User createUser(User request);

    User updateBalance(User user, Long balance);


}
