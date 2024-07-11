package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.ClassSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubject, Long> {
    List<ClassSubject> findByFacultyId(Long facultyId);
    List<ClassSubject> findByStudentsId(Long studentId);
}