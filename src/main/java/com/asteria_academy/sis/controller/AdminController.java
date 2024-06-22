package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.*;
import com.asteria_academy.sis.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/asteria-academy/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ClassService classService;

    @GetMapping("/list")
    public Optional<Student> getAllUsers() {
        return userService.getAllUsers();
    }
}
