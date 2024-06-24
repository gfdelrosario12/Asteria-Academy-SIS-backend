package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, String> {
}
