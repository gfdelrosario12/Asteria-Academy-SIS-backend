package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Method to create a student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Method to retrieve all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Method to retrieve a student by user_id
    public Optional<Student> getStudentById(String userId) {
        return studentRepository.findById(userId);
    }

    // Method to retrieve all students using custom query
    public Optional<Student> getAllStudentsCustomQuery() {
        return studentRepository.findAllStudents();
    }

    // Method to update an existing student
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    // Method to delete a student by user_id
    public void deleteStudent(String userId) {
        studentRepository.deleteById(userId);
    }
}
