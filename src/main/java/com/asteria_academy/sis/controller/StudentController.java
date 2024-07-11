package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.ClassSubject;
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
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudentsWithoutClassSubjects();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
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
            existingStudent.setClassSubjects(student.getClassSubjects());
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

    @GetMapping("/studentsinclass/{classSubjectId}")
    public ResponseEntity<List<Student>> getStudentsByClassSubjectId(@PathVariable("classSubjectId") Long classSubjectId) {
        List<Student> students = studentService.getStudentsByClassSubjectId(classSubjectId);
        for (Student student : students) {
            student.setClassSubjects(null); // or any other logic to exclude students
        }
        return ResponseEntity.ok(students);
    }
}
