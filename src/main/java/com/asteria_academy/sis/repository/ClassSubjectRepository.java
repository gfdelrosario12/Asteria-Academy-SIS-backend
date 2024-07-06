package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.ClassSubject;
import com.asteria_academy.sis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubject, Long> {

    List<ClassSubject> findByFaculty_Id(Long facultyId);

}
