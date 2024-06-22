package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradesService {

    @Autowired
    private GradeRepository gradeRepository;

    public Grade createGrade(Grade grade) {
        // Implement any additional business logic if needed
        return gradeRepository.save(grade);
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(String gradeId) {
        return gradeRepository.findById(gradeId);
    }

    public Grade updateGrade(Grade grade) {
        // Implement update logic, ensuring grade_id exists
        return gradeRepository.save(grade);
    }

    public void deleteGrade(String gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
