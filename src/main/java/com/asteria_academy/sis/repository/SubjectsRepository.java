package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SubjectsRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT c FROM Subject c")
    Optional<Student> getAllSubjects();
}