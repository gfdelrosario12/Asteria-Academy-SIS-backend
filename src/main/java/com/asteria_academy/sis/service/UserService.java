package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.AdministratorRepository;
import com.asteria_academy.sis.repository.FacultyRepository;
import com.asteria_academy.sis.repository.StudentRepository;
import com.asteria_academy.sis.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    public Optional<Student> getAllUsers() {
        return studentRepository.findAllStudents();
    }
}

