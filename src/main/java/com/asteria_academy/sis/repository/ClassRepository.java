package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClassRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT u FROM Student u WHERE u.user_id = ?1")
    Optional<Student> findByUsername();
}