package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/")
    public List<Grade> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id).orElse(null);
    }
    @GetMapping("/distinct-school-years/{studentId}")
    public List<Integer> getDistinctSchoolYearsByStudentId(@PathVariable Long studentId) {
        return gradeService.getDistinctSchoolYearsByStudentId(studentId);
    }

    @GetMapping("/distinct-school-years/{studentId}/{schoolYear}/semesters")
    public List<Integer> getDistinctSemestersByStudentIdAndSchoolYear(@PathVariable Long studentId, @PathVariable int schoolYear) {
        return gradeService.getDistinctSemestersByStudentIdAndSchoolYear(studentId, schoolYear);
    }

    @GetMapping("/{studentId}/school-years/{schoolYear}/semesters/{semester}/ids")
    public List<Long> getIdsByStudentIdAndSchoolYearAndSemester(@PathVariable Long studentId, @PathVariable int schoolYear, @PathVariable int semester) {
        return gradeService.getIdsByStudentIdAndSchoolYearAndSemester(studentId, schoolYear, semester);
    }

    @PostMapping("/")
    public Grade createGrade(@RequestBody Grade grade) {
        return gradeService.saveGrade(grade);
    }

    @PutMapping("/{id}")
    public Grade updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        Grade existingGrade = gradeService.getGradeById(id).orElse(null);
        if (existingGrade != null) {
            existingGrade.setStudent(grade.getStudent());
            existingGrade.setClassSubjectObj(grade.getClassSubjectObj());
            existingGrade.setSchool_year(grade.getSchool_year());
            existingGrade.setYear_level(grade.getYear_level());
            existingGrade.setSemester(grade.getSemester());
            existingGrade.setProgram(grade.getProgram());
            existingGrade.setBlock(grade.getBlock());
            existingGrade.setGrade(grade.getGrade());
            return gradeService.updateGrade(existingGrade);
        } else {
            return null;
        }
    }


    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }
}
