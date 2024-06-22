package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT s FROM Student s")
    Optional<Student> findAllStudents();
}
