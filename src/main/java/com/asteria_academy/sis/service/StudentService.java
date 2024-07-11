package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.ClassSubject;
import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.ClassSubjectRepository;
import com.asteria_academy.sis.repository.StudentRepository;
import com.asteria_academy.sis.security.algorithm.PasswordArgon2SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final PasswordArgon2SpringSecurity passwordEncoder = new PasswordArgon2SpringSecurity();

    public boolean login(String username, String rawPassword) {
        List<Student> students = studentRepository.findAllByUsername(username);
        if (students.size() == 1) {
            Student student = students.get(0);
            String salt = student.getSalt();
            String hash = student.getPassword();
            return passwordEncoder.matchPasswords(salt, rawPassword, hash);
        } else {
            // Handle cases where no students or multiple students are found
            return false;
        }
    }


    public Long getLastInsertedId() {
        // Assuming your id field is Long and auto-generated
        // You can fetch the last inserted id by sorting in descending order
        List<Student> entities = studentRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        if (!entities.isEmpty()) {
            return entities.get(0).getId() + 1;
        } else {
            return 1L; // or handle accordingly if no entities are found
        }
    }

    public String username(Long lastID) {
        String role = "STUDENT";
        return "AA-" + role + "-" + lastID;
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

    // Method to fetch students without their associated class subjects
    public List<Student> getAllStudentsWithoutClassSubjects() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            student.setClassSubjects(null); // Set associated class subjects to null
        }
        return students;
    }

    public List<Student> getStudentsByClassSubjectId(Long classSubjectId) {
        return studentRepository.findStudentsByClassSubjectId(classSubjectId);
    }
}
