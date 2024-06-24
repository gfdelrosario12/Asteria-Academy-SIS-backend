package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Faculty;
import com.asteria_academy.sis.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asteria-academy/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/all")
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable String id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        return faculty.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFaculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable String id, @RequestBody Faculty faculty) {
        if (!id.equals(faculty.getFaculty_id())) {
            return ResponseEntity.badRequest().build();
        }
        Faculty updatedFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable String id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
