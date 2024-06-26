package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Faculty;
import com.asteria_academy.sis.entity.LogIn;
import com.asteria_academy.sis.service.FacultyService;
import com.asteria_academy.sis.security.algorithm.PasswordArgon2SpringSecurity;
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

    @PostMapping("/login")
    public String login(@RequestBody LogIn loginRequest) {
        boolean isAuthenticated = facultyService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (isAuthenticated) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Long id) {
        return new ResponseEntity<>(facultyService.getFacultyById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        PasswordArgon2SpringSecurity passwordSecurity = new PasswordArgon2SpringSecurity();
        String salt = passwordSecurity.generateSalt();
        String hashedPassword = passwordSecurity.encryptPassword(faculty.getPassword(), salt);

        faculty.setPassword(hashedPassword);
        faculty.setSalt(salt);

        return new ResponseEntity<>(facultyService.saveFaculty(faculty), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        Faculty existingFaculty = facultyService.getFacultyById(id).orElse(null);
        if (existingFaculty != null) {
            existingFaculty.setEmail(faculty.getEmail());
            existingFaculty.setPassword(faculty.getPassword());
            existingFaculty.setSalt(faculty.getSalt());
            existingFaculty.setFull_name(faculty.getFull_name());
            existingFaculty.setAddress(faculty.getAddress());
            existingFaculty.setGender(faculty.getGender());
            existingFaculty.setMobile_number(faculty.getMobile_number());
            existingFaculty.setRole(faculty.getRole());
            existingFaculty.setDepartment(faculty.getDepartment());
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
