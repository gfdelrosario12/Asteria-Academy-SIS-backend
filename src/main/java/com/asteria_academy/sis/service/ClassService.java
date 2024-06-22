package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Subject;
import com.asteria_academy.sis.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Subject> getAllClasses() {
        return classRepository.findAll();
    }
}
