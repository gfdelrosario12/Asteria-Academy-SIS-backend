package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId AND g.classSubjectObj.id = :classId")
    List<Grade> findByStudentIdAndClassId(@Param("studentId") Long studentId, @Param("classId") Long classId);
}
