package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Student, Long> {

    @Query("SELECT u FROM Student u WHERE u.username = ?1")
    Optional<Student> findByUsername();
}