package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.entity.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GradeRepository {
    @Query("SELECT u FROM Student u WHERE u.user_id = ?1")
    Optional<Student> findByUsername();
}
