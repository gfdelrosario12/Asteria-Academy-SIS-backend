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

    // Endpoint to create a new faculty member
    @PostMapping("/")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = facultyService.createFaculty(faculty);
        return new ResponseEntity<>(createdFaculty, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all faculty members
    @GetMapping("/")
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        List<Faculty> facultyList = facultyService.getAllFaculty();
        return new ResponseEntity<>(facultyList, HttpStatus.OK);
    }

    // Endpoint to retrieve a faculty member by faculty_id
    @GetMapping("/{facultyId}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable String facultyId) {
        Optional<Faculty> faculty = facultyService.getFacultyById(facultyId);
        return faculty.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to retrieve all faculty members using custom query
    @GetMapping("/all")
    public ResponseEntity<Faculty> getAllFacultyCustomQuery() {
        Optional<Faculty> facultyList = facultyService.getAllFacultyCustomQuery();
        return facultyList.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing faculty member
    @PutMapping("/{facultyId}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable String facultyId,
                                                 @RequestBody Faculty faculty) {
        if (!facultyId.equals(faculty.getFaculty_id())) {
            return ResponseEntity.badRequest().build();
        }
        Faculty updatedFaculty = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    // Endpoint to delete a faculty member by faculty_id
    @DeleteMapping("/{facultyId}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable String facultyId) {
        facultyService.deleteFaculty(facultyId);
        return ResponseEntity.noContent().build();
    }
}
