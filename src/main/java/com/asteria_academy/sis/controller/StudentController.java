package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asteria-academy/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Endpoint to create a new student
    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all students
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    // Endpoint to retrieve a student by user_id
    @GetMapping("/{userId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String userId) {
        Optional<Student> student = studentService.getStudentById(userId);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to retrieve all students using custom query
    @GetMapping("/all")
    public ResponseEntity<Student> getAllStudentsCustomQuery() {
        Optional<Student> studentList = studentService.getAllStudentsCustomQuery();
        return studentList.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing student
    @PutMapping("/{userId}")
    public ResponseEntity<Student> updateStudent(@PathVariable String userId,
                                                 @RequestBody Student student) {
        if (!userId.equals(student.getUser_id())) {
            return ResponseEntity.badRequest().build();
        }
        Student updatedStudent = studentService.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    // Endpoint to delete a student by user_id
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String userId) {
        studentService.deleteStudent(userId);
        return ResponseEntity.noContent().build();
    }
}
