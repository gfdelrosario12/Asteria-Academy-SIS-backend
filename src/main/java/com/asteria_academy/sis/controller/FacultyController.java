package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Faculty;
import com.asteria_academy.sis.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/")
    public ResponseEntity<List<Faculty>> getAllFaculties() {
        return new ResponseEntity<>(facultyService.getAllFaculties(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        return new ResponseEntity<>(facultyService.getFacultyById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        return new ResponseEntity<>(facultyService.saveFaculty(faculty), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        Faculty existingFaculty = facultyService.getFacultyById(id).orElse(null);
        if (existingFaculty != null) {
            existingFaculty.setName(faculty.getName());
            existingFaculty.setDepartment(faculty.getName());
            return new ResponseEntity<>(facultyService.updateFaculty(existingFaculty), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFaculty(@PathVariable Long id) {
        try {
            facultyService.deleteFaculty(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
