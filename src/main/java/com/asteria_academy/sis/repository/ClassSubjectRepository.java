package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Class_Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSubjectRepository  extends JpaRepository<Class_Subject, Long> {

    @Query("SELECT DISTINCT cs.school_year FROM Class_Subject cs WHERE cs.faculty.id = :facultyId ORDER BY cs.school_year")
    List<Integer> findDistinctSchoolYearsByFacultyId(@Param("facultyId") Long facultyId);

    @Query("SELECT DISTINCT cs.year_level FROM Class_Subject cs WHERE cs.faculty.id = :facultyId AND cs.school_year = :schoolYear ORDER BY cs.year_level")
    List<Integer> findDistinctYearLevelsByFacultyIdAndSchoolYear(@Param("facultyId") Long facultyId, @Param("schoolYear") int schoolYear);

    @Query("SELECT DISTINCT cs.semester FROM Class_Subject cs WHERE cs.faculty.id = :facultyId AND cs.school_year = :schoolYear AND cs.year_level = :yearLevel ORDER BY cs.semester")
    List<Integer> findDistinctSemestersByFacultyIdAndSchoolYearAndYearLevel(@Param("facultyId") Long facultyId, @Param("schoolYear") int schoolYear, @Param("yearLevel") int yearLevel);

    @Query("SELECT cs.id FROM Class_Subject cs WHERE cs.faculty.id = :facultyId AND cs.school_year = :schoolYear AND cs.year_level = :yearLevel AND cs.semester = :semester")
    List<Long> findIdsByFacultyIdAndSchoolYearAndYearLevelAndSemester(@Param("facultyId") Long facultyId, @Param("schoolYear") int schoolYear, @Param("yearLevel") int yearLevel, @Param("semester") int semester);
}
