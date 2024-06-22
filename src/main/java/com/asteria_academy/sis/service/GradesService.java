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

    public List<Grade> getAllGrades() {
        return gradeRepository.findByStudentId(1L);
    }
}
