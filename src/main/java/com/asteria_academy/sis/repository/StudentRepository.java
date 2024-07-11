package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.ClassSubject;
import com.asteria_academy.sis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByUsername(String username);

    @Query("SELECT s FROM Student s JOIN s.classSubjects cs WHERE cs.id = :classSubjectId")
    List<Student> findStudentsByClassSubjectId(@Param("classSubjectId") Long classSubjectId);
}
