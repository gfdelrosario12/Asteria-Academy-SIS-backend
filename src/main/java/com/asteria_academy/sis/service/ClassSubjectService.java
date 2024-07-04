package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Class_Subject;
import com.asteria_academy.sis.repository.ClassSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassSubjectService {

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    public List<Class_Subject> getAllClassSubjects() {
        return classSubjectRepository.findAll();
    }

    public Optional<Class_Subject> getClassSubjectById(Long id) {
        return classSubjectRepository.findById(id);
    }

    public Class_Subject saveClassSubject(Class_Subject classSubject) {
        return classSubjectRepository.save(classSubject);
    }

    public Class_Subject updateClassSubject(Class_Subject classSubject) {
        return classSubjectRepository.save(classSubject);
    }

    public void deleteClassSubject(Long id) {
        classSubjectRepository.deleteById(id);
    }

    public List<Class_Subject> getClassesByFacultyId(Long facultyId) {
        return classSubjectRepository.findByFaculty_Id(facultyId);
    }
}
