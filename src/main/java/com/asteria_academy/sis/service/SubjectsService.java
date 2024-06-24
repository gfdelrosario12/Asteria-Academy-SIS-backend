package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Subject;
import com.asteria_academy.sis.repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    public List<Subject> getAllSubjects() {
        return subjectsRepository.findAll();
    }

    public Optional<Subject> getSubjectById(String id) {
        return subjectsRepository.findById(id);
    }

    public Subject saveSubject(Subject subject) {
        return subjectsRepository.save(subject);
    }

    public void deleteSubject(String id) {
        subjectsRepository.deleteById(id);
    }
}
