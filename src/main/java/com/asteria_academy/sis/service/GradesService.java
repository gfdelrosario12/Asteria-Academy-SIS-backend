package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.GradeRepository;
import com.asteria_academy.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService {
    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getAllUsers() {
        return studentRepository.findAllStudents();
    }
}
