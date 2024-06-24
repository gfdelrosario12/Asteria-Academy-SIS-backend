package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/asteria-academy/grades")
public class GradesController {

    @Autowired
    private GradesService gradeService;

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable String id) {
        Optional<Grade> grade = gradeService.getGradeById(id);
        return grade.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a grade
    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable String id, @RequestBody Grade updatedGrade) {
        Optional<Grade> existingGradeOptional = gradeService.getGradeById(id);

        if (existingGradeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Grade existingGrade = existingGradeOptional.get();

        // Update properties from updatedGrade
        existingGrade.setSchool_year(updatedGrade.getSchool_year());
        existingGrade.setYear_level(updatedGrade.getYear_level());
        existingGrade.setSemester(updatedGrade.getSemester());
        existingGrade.setProgram(updatedGrade.getProgram());
        existingGrade.setSubject1(updatedGrade.getSubject1());
        existingGrade.setSubject2(updatedGrade.getSubject2());
        existingGrade.setSubject3(updatedGrade.getSubject3());
        existingGrade.setSubject4(updatedGrade.getSubject4());
        existingGrade.setSubject5(updatedGrade.getSubject5());
        existingGrade.setSubject6(updatedGrade.getSubject6());
        existingGrade.setSubject7(updatedGrade.getSubject7());
        existingGrade.setSubject8(updatedGrade.getSubject8());
        existingGrade.setSubject9(updatedGrade.getSubject9());

        // Save the updated grade
        Grade savedGrade = gradeService.saveGrade(existingGrade);
        return ResponseEntity.ok(savedGrade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable String id) {
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}
