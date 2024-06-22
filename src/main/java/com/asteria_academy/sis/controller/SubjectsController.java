package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.service.SubjectsService;
import com.asteria_academy.sis.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asteria-academy/subjects")
public class SubjectsController {
    @Autowired
    private SubjectsService subjectService;

    // Endpoint to create a subject (class)
    @PostMapping("/classes")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectService.createSubject(subject);
        return new ResponseEntity<>(createdSubject, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all subjects (classes)
    @GetMapping("/classes")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjectList = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjectList, HttpStatus.OK);
    }

    // Endpoint to retrieve a subject (class) by subject_id
    @GetMapping("/classes/{subjectId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long subject_id) {
        Optional<Subject> subject = subjectService.getSubjectById(subject_id);
        return subject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing subject (class)
    @PutMapping("/classes/{subjectId}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String subjectId,
                                                 @RequestBody Subject subject) {
        if (!subjectId.equals(subject.getSubject_id())) {
            return ResponseEntity.badRequest().build();
        }
        Subject updatedSubject = subjectService.updateSubject(subject);
        return ResponseEntity.ok(updatedSubject);
    }

    // Endpoint to delete a subject (class) by subject_id
    @DeleteMapping("/classes/{subjectId}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long subject_id) {
        subjectService.deleteSubject(subject_id);
        return ResponseEntity.noContent().build();
    }
}
