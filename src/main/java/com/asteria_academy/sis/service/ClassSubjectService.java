package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.ClassSubject;
import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.ClassSubjectRepository;
import com.asteria_academy.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClassSubjectService {

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<ClassSubject> getAllClassSubjects() {
        return classSubjectRepository.findAll();
    }

    public Optional<ClassSubject> getClassSubjectById(Long id) {
        return classSubjectRepository.findById(id);
    }

    public ClassSubject saveClassSubject(ClassSubject classSubject) {
        return classSubjectRepository.save(classSubject);
    }

    public ClassSubject updateClassSubject(ClassSubject classSubject) {
        return classSubjectRepository.save(classSubject);
    }

    public void deleteClassSubject(Long id) {
        classSubjectRepository.deleteById(id);
    }

    public List<ClassSubject> getClassesByFacultyId(Long facultyId) {
        return classSubjectRepository.findByFaculty_Id(facultyId);
    }

    public void updateStudentsInClassSubject(Long classSubjectId, Long[] studentsToAdd, Long[] studentsToRemove) {
        // Fetch the ClassSubject entity by ID
        ClassSubject classSubject = classSubjectRepository.findById(classSubjectId)
                .orElseThrow(() -> new RuntimeException("ClassSubject not found with id: " + classSubjectId));

        // Fetch all students to add
        List<Student> studentsToAddList = studentRepository.findAllById(Arrays.asList(studentsToAdd));

        // Fetch all students to remove
        List<Student> studentsToRemoveList = studentRepository.findAllById(Arrays.asList(studentsToRemove));

        // Remove students from the class
        classSubject.getStudents().removeAll(studentsToRemoveList);

        // Add students to the class
        classSubject.getStudents().addAll(studentsToAddList);

        // Save the updated ClassSubject entity
        classSubjectRepository.save(classSubject);
    }


}
