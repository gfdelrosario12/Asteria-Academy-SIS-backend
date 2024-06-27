package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(Long id) {
        return gradeRepository.findById(id);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade updateGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }

    public List<Integer> getDistinctSchoolYearsByStudentId(Long studentId) {
        return gradeRepository.findDistinctSchoolYearsByStudentId(studentId);
    }

    public List<Integer> getDistinctSemestersByStudentIdAndSchoolYear(Long studentId, int schoolYear) {
        return gradeRepository.findDistinctSemestersByStudentIdAndSchoolYear(studentId, schoolYear);
    }

    public List<Long> getIdsByStudentIdAndSchoolYearAndSemester(Long studentId, int schoolYear, int semester) {
        return gradeRepository.findIdsByStudentIdAndSchoolYearAndSemester(studentId, schoolYear, semester);
    }
}
