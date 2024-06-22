package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Administrator;
import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.service.AdministratorService;
import com.asteria_academy.sis.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asteria-academy/grades")
public class GradesController {
    @Autowired
    private GradesService gradesService;

    // Endpoint to create a new administrator
    @PostMapping("/grades")
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade createdGrade = gradesService.createGrade(grade);
        return new ResponseEntity<>(createdGrade, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all grades
    @GetMapping("/grades")
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> gradeList = gradesService.getAllGrades();
        return new ResponseEntity<>(gradeList, HttpStatus.OK);
    }

    // Endpoint to retrieve a grade by grade_id
    @GetMapping("/grades/{gradeId}")
    public ResponseEntity<Grade> getGradeById(@PathVariable String gradeId) {
        Optional<Grade> grade = gradesService.getGradeById(gradeId);
        return grade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing grade
    @PutMapping("/grades/{gradeId}")
    public ResponseEntity<Grade> updateGrade(@PathVariable String gradeId,
                                             @RequestBody Grade grade) {
        if (!gradeId.equals(grade.getGrade_id())) {
            return ResponseEntity.badRequest().build();
        }
        Grade updatedGrade = gradesService.updateGrade(grade);
        return ResponseEntity.ok(updatedGrade);
    }

    // Endpoint to delete a grade by grade_id
    @DeleteMapping("/grades/{gradeId}")
    public ResponseEntity<Void> deleteGrade(@PathVariable String gradeId) {
        gradesService.deleteGrade(gradeId);
        return ResponseEntity.noContent().build();
    }
}
