package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
