package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Faculty;
import com.asteria_academy.sis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, String> {
    @Query("SELECT u FROM Student u WHERE u.user_id = ?1")
    Optional<Student> findByUsername();
}
