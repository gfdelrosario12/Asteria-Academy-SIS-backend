package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, String> {
}
