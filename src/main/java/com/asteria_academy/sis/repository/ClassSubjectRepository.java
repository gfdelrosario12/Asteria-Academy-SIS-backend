package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Class_Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSubjectRepository  extends JpaRepository<Class_Subject, Long> {
    // Custom queries if needed
}
