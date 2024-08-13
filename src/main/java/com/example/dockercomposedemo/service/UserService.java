package com.example.dockercomposedemo.service;

import com.example.dockercomposedemo.entity.User;
import com.example.dockercomposedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email) {
        User newUser = new User(username, email);
        return userRepository.save(newUser);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // 다른 메서드들...
}