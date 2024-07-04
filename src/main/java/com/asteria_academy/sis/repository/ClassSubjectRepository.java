package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Class_Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSubjectRepository extends JpaRepository<Class_Subject, Long> {

    List<Class_Subject> findByFaculty_Id(Long facultyId);}
