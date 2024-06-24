package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Subject;
import com.asteria_academy.sis.service.SubjectsService;
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
    private SubjectsService subjectsService;

    @GetMapping("/all")
    public List<Subject> getAllSubjects() {
        return subjectsService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable String id) {
        Optional<Subject> subject = subjectsService.getSubjectById(id);
        return subject.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        Subject createdSubject = subjectsService.saveSubject(subject);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable String id, @RequestBody Subject subject) {
        if (!id.equals(subject.getSubject_id())) {
            return ResponseEntity.badRequest().build();
        }
        Subject updatedSubject = subjectsService.saveSubject(subject);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
        subjectsService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
