package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subject, String> {
}
