package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Grade;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GradeRepository {
    @Query("SELECT g FROM Grade g WHERE g.student.id = ?1")
    List<Grade> findByStudentId(Long studentId);

    @Query("SELECT g FROM Grade g WHERE g.faculty.id = ?1")
    List<Grade> findByFacultyId(Long facultyId);

    @Query("SELECT g FROM Grade g WHERE g.clazz.id = ?1")
    List<Grade> findByClassId(Long classId);
}
