package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Implement REST endpoints for CRUD operations

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student existingStudent = studentService.getStudentById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setEmail(student.getEmail());
            existingStudent.setHash(student.getHash());
            existingStudent.setSalt(student.getSalt());
            existingStudent.setFull_name(student.getFull_name());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setGender(student.getGender());
            existingStudent.setMobile_number(student.getMobile_number());
            existingStudent.setRole(student.getRole());
            return studentService.updateStudent(existingStudent);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
