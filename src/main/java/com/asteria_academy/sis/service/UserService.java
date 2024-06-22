package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<Student> getAllUsers() {
        return userRepository.findByUsername();
    }
}

