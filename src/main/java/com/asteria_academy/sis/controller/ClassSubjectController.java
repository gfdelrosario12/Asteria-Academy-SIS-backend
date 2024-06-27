package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Class_Subject;
import com.asteria_academy.sis.service.ClassSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class-subjects")
public class ClassSubjectController {

    @Autowired
    private ClassSubjectService classSubjectService;

    @GetMapping("/")
    public ResponseEntity<List<Class_Subject>> getAllClassSubjects() {
        return new ResponseEntity<>(classSubjectService.getAllClassSubjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class_Subject> getClassSubjectById(@PathVariable Long id) {
        return new ResponseEntity<>(classSubjectService.getClassSubjectById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/distinct-school-years-by-faculty/{facultyId}")
    public List<Integer> getDistinctSchoolYearsByFacultyId(@PathVariable Long facultyId) {
        return classSubjectService.getDistinctSchoolYearsByFacultyId(facultyId);
    }

    @GetMapping("/distinct-year-levels-by-faculty-and-school-year/{facultyId}/{schoolYear}")
    public List<Integer> getDistinctYearLevelsByFacultyIdAndSchoolYear(@PathVariable Long facultyId, @PathVariable int schoolYear) {
        return classSubjectService.getDistinctYearLevelsByFacultyIdAndSchoolYear(facultyId, schoolYear);
    }

    @GetMapping("/distinct-semesters-by-faculty-and-school-year-and-year-level/{facultyId}/{schoolYear}/{yearLevel}")
    public List<Integer> getDistinctSemestersByFacultyIdAndSchoolYearAndYearLevel(@PathVariable Long facultyId, @PathVariable int schoolYear, @PathVariable int yearLevel) {
        return classSubjectService.getDistinctSemestersByFacultyIdAndSchoolYearAndYearLevel(facultyId, schoolYear, yearLevel);
    }

    @GetMapping("/ids-by-faculty-and-school-year-and-year-level-and-semester/{facultyId}/{schoolYear}/{yearLevel}/{semester}")
    public List<Long> getIdsByFacultyIdAndSchoolYearAndYearLevelAndSemester(@PathVariable Long facultyId, @PathVariable int schoolYear, @PathVariable int yearLevel, @PathVariable int semester) {
        return classSubjectService.getIdsByFacultyIdAndSchoolYearAndYearLevelAndSemester(facultyId, schoolYear, yearLevel, semester);
    }

    @PostMapping("/")
    public ResponseEntity<Class_Subject> createClassSubject(@RequestBody Class_Subject classSubject) {
        return new ResponseEntity<>(classSubjectService.saveClassSubject(classSubject), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Class_Subject> updateClassSubject(@PathVariable Long id, @RequestBody Class_Subject classSubject) {
        Class_Subject existingClassSubject = classSubjectService.getClassSubjectById(id).orElse(null);
        if (existingClassSubject != null) {
            existingClassSubject.setClassName(classSubject.getClassName());
            existingClassSubject.setSchool_year(classSubject.getSchool_year());
            existingClassSubject.setYear_level(classSubject.getYear_level());
            existingClassSubject.setSemester(classSubject.getSemester());
            existingClassSubject.setProgram(classSubject.getProgram());
            existingClassSubject.setBlock(classSubject.getBlock());
            existingClassSubject.setFaculty(classSubject.getFaculty());
            return new ResponseEntity<>(classSubjectService.updateClassSubject(existingClassSubject), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteClassSubject(@PathVariable Long id) {
        try {
            classSubjectService.deleteClassSubject(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
