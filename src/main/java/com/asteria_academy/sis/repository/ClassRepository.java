package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {

    @Query("SELECT c FROM Class c WHERE c.teacher.id = ?1")
    List<Class> findByTeacherId(Long teacherId);

    @Query("SELECT c FROM Class c JOIN c.students s WHERE s.id = ?1")
    List<Class> findByStudentId(Long studentId);
}