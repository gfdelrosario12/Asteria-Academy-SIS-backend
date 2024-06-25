package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id).orElse(null);
    }

    @PostMapping("/")
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @PutMapping("/{id}")
public Grade updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        Grade existingGrade = gradeService.getGradeById(id).orElse(null);
        if (existingGrade != null) {
            existingGrade.setGrade(grade.getGrade());
            existingGrade.setStudent(grade.getStudent());
            existingGrade.setClassSubjectObj(grade.getClassSubjectObj());
            existingGrade.setGrade(grade.getGrade());
            return gradeService.updateGrade(existingGrade);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }
}
