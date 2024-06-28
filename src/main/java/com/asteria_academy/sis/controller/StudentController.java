package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.LogIn;
import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.security.algorithm.PasswordArgon2SpringSecurity;
import com.asteria_academy.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        // Assuming the password hashing and salting process should be handled before saving
        PasswordArgon2SpringSecurity passwordSecurity = new PasswordArgon2SpringSecurity();
        String salt = PasswordArgon2SpringSecurity.generateSalt();
        String hashedPassword = PasswordArgon2SpringSecurity.encryptPassword(student.getPassword(), salt);

        student.setPassword(hashedPassword);
        student.setSalt(salt);
        Long lastID = studentService.getLastInsertedId();
        String username = studentService.username(lastID);
        student.setUsername(username);

        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody LogIn loginRequest) {
        boolean isAuthenticated = studentService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student existingStudent = studentService.getStudentById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setEmail(student.getEmail());
            existingStudent.setPassword(student.getPassword());
            existingStudent.setSalt(student.getSalt());
            existingStudent.setFull_name(student.getFull_name());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setGender(student.getGender());
            existingStudent.setMobile_number(student.getMobile_number());
            existingStudent.setRole(student.getRole());
            return new ResponseEntity<>(studentService.updateStudent(existingStudent), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
