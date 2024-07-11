package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.ClassSubject;
import com.asteria_academy.sis.service.ClassSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/class-subjects")
public class ClassSubjectController {

    @Autowired
    private ClassSubjectService classSubjectService;

    @GetMapping("/")
    public ResponseEntity<List<ClassSubject>> getAllClassSubjects() {
        List<ClassSubject> classSubjects = classSubjectService.getAllClassSubjects();
        for (ClassSubject classSubject : classSubjects) {
            classSubject.setStudents(null); // or any other logic to exclude students
        }
        return new ResponseEntity<>(classSubjects, HttpStatus.OK);
    }

    @GetMapping("/faculty/{facultyId}/classes")
    public ResponseEntity<List<ClassSubject>> getClassesByFacultyId(@PathVariable Long facultyId) {
        List<ClassSubject> classes = classSubjectService.getClassesByFacultyId(facultyId);
        for (ClassSubject classSubject : classes) {
            classSubject.setStudents(null); // or any other logic to exclude students
        }
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassSubject> getClassSubjectById(@PathVariable Long id) {
        return new ResponseEntity<>(classSubjectService.getClassSubjectById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}/classes")
    public ResponseEntity<List<ClassSubject>> getClassesByStudentId(@PathVariable Long studentId) {
        List<ClassSubject> classes = classSubjectService.getClassesByStudentId(studentId);
        for (ClassSubject classSubject : classes) {
            classSubject.setStudents(null); // or any other logic to exclude students
        }
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }

    @PostMapping("/{facultyId}")
    public ResponseEntity<ClassSubject> createClassSubject(@RequestBody ClassSubject classSubject, @PathVariable Long facultyId) {
        ClassSubject savedClassSubject = classSubjectService.saveClassSubject(classSubject, facultyId);
        return new ResponseEntity<>(savedClassSubject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassSubject> updateClassSubject(@PathVariable Long id, @RequestBody ClassSubject classSubject) {
        ClassSubject existingClassSubject = classSubjectService.getClassSubjectById(id).orElse(null);
        if (existingClassSubject != null) {
            existingClassSubject.setClassName(classSubject.getClassName());
            existingClassSubject.setSchoolYear(classSubject.getSchoolYear());
            existingClassSubject.setYearLevel(classSubject.getYearLevel());
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

    @PutMapping("/{classSubjectId}/update-students")
    public ResponseEntity<String> updateStudentsInClassSubject(
            @PathVariable Long classSubjectId,
            @RequestBody UpdateStudentsRequest request) {

        Long[] studentsToAdd = request.getStudentsToAdd();
        Long[] studentsToRemove = request.getStudentsToRemove();

        classSubjectService.updateStudentsInClassSubject(classSubjectId, studentsToAdd, studentsToRemove);

        return ResponseEntity.ok("Students updated in ClassSubject successfully");
    }

    static class UpdateStudentsRequest {
        private Long[] studentsToAdd;
        private Long[] studentsToRemove;

        public Long[] getStudentsToAdd() {
            return studentsToAdd;
        }

        public void setStudentsToAdd(Long[] studentsToAdd) {
            this.studentsToAdd = studentsToAdd;
        }

        public Long[] getStudentsToRemove() {
            return studentsToRemove;
        }

        public void setStudentsToRemove(Long[] studentsToRemove) {
            this.studentsToRemove = studentsToRemove;
        }
    }

    @PutMapping("/{classSubjectId}/add-student/{studentId}")
    public ResponseEntity<ClassSubject> addStudentToClassSubject(
            @PathVariable Long classSubjectId,
            @PathVariable Long studentId) {
        try {
            classSubjectService.addStudentToClassSubject(classSubjectId, studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{classSubjectId}/remove-student/{studentId}")
    public ResponseEntity<ClassSubject> removeStudentFromClassSubject(
            @PathVariable Long classSubjectId,
            @PathVariable Long studentId) {
        try {
            classSubjectService.removeStudentFromClassSubject(classSubjectId, studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
