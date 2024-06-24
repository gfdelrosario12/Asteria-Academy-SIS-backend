package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradesService {

    @Autowired
    private GradeRepository gradeRepository;

    public Optional<Grade> getGradeById(String id) {
        return gradeRepository.findById(id);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteGrade(String id) {
        gradeRepository.deleteById(id);
    }
}
