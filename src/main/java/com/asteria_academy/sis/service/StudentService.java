package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.StudentRepository;
import com.asteria_academy.sis.security.algorithm.PasswordArgon2SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final PasswordArgon2SpringSecurity passwordEncoder = new PasswordArgon2SpringSecurity();

    public boolean login(String email, String rawPassword) {
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            String salt = student.getSalt();
            String hash = student.getPassword();
            return passwordEncoder.matchPasswords(salt, rawPassword, hash);
        }
        return false;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
