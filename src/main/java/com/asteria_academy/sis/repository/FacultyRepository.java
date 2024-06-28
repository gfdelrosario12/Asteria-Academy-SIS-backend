package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByUsername(String username);
}
