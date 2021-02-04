package com.example.az.service.impl;

import com.example.az.model.User;
import com.example.az.repository.UserRepository;
import com.example.az.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User request) {
        request.setBalance(0L);
        return userRepository.save(request);
    }

    @Override
    public User updateBalance(User user, Long balance) {
        user.setBalance(balance);
        user.setId(user.getId());
        return userRepository.save(user);
    }
}
