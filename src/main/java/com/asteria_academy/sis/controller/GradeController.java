package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.entity.ClassSubject;
import com.asteria_academy.sis.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/")
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> grades = gradeService.getAllGrades();
        List<Grade> modifiedGrades = grades.stream().map(this::mapToModifiedGrade).collect(Collectors.toList());
        return new ResponseEntity<>(modifiedGrades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> gradeOpt = gradeService.getGradeById(id);
        return gradeOpt.map(grade -> new ResponseEntity<>(mapToModifiedGrade(grade), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Grade> createGrade(@RequestBody Grade grade) {
        Grade savedGrade = gradeService.saveGrade(grade);
        return new ResponseEntity<>(mapToModifiedGrade(savedGrade), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade updatedGrade) {
        Optional<Grade> existingGradeOpt = gradeService.getGradeById(id);
        if (existingGradeOpt.isPresent()) {
            Grade existingGrade = existingGradeOpt.get();
            existingGrade.setGrade(updatedGrade.getGrade()); // Only update the grade field
            Grade savedGrade = gradeService.updateGrade(existingGrade);
            return new ResponseEntity<>(mapToModifiedGrade(savedGrade), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        Optional<Grade> gradeOpt = gradeService.getGradeById(id);
        if (gradeOpt.isPresent()) {
            gradeService.deleteGrade(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/student/{studentId}/class/{classId}")
    public ResponseEntity<List<Grade>> getGradesByStudentIdAndClassId(@PathVariable Long studentId, @PathVariable Long classId) {
        List<Grade> grades = gradeService.getGradesByStudentIdAndClassId(studentId, classId);
        List<Grade> modifiedGrades = grades.stream().map(grade -> {
            Grade g = new Grade();
            g.setId(grade.getId());
            Student student = new Student();
            student.setId(grade.getStudent().getId());
            g.setStudent(student);
            ClassSubject classSubject = new ClassSubject();
            classSubject.setId(grade.getClassSubjectObj().getId());
            g.setClassSubjectObj(classSubject);
            g.setGrade(grade.getGrade());
            return g;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(modifiedGrades, HttpStatus.OK);
    }

    private Grade mapToModifiedGrade(Grade grade) {
        Grade modifiedGrade = new Grade();
        modifiedGrade.setId(grade.getId());
        Student student = new Student();
        student.setId(grade.getStudent().getId());
        modifiedGrade.setStudent(student);
        ClassSubject classSubject = new ClassSubject();
        classSubject.setId(grade.getClassSubjectObj().getId());
        modifiedGrade.setClassSubjectObj(classSubject);
        modifiedGrade.setGrade(grade.getGrade());
        return modifiedGrade;
    }
}
