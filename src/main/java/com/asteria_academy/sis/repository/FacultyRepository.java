package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, String> {
    @Query("SELECT f FROM Faculty f")
    Optional<Faculty> findAllFaculty();
}
