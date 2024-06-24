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

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        if (!id.equals(student.getUser_id())) {
            return ResponseEntity.badRequest().build();
        }
        Student updatedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
