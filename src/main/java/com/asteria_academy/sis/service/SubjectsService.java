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

    public Subject createSubject(Subject subject) {
        // Implement any additional business logic if needed
        return subjectsRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectsRepository.findAll();
    }

    public Optional<Subject> getSubjectById(Long subject_id) {
        return subjectsRepository.findById(subject_id);
    }

    public Subject updateSubject(Subject subject) {
        // Implement update logic, ensuring subject_id exists
        return subjectsRepository.save(subject);
    }

    public void deleteSubject(Long subject_id) {
        subjectsRepository.deleteById(subject_id);
    }
}
