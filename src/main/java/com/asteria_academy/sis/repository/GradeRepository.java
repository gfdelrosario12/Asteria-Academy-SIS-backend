package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    @Query("SELECT DISTINCT g.school_year FROM Grade g ORDER BY g.school_year")
    List<Integer> findDistinctSchoolYears();

    @Query("SELECT DISTINCT g.semester FROM Grade g WHERE g.school_year = :schoolYear ORDER BY g.semester")
    List<Integer> findDistinctSemestersBySchoolYear(@Param("schoolYear") int schoolYear);

    @Query("SELECT g.id FROM Grade g WHERE g.school_year = :schoolYear AND g.semester = :semester")
    List<Long> findIdsBySchoolYearAndSemester(@Param("schoolYear") int schoolYear, @Param("semester") int semester);
}
