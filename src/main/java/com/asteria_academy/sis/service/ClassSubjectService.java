package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.ClassSubject;
import com.asteria_academy.sis.entity.Faculty;
import com.asteria_academy.sis.entity.Student;
import com.asteria_academy.sis.repository.ClassSubjectRepository;
import com.asteria_academy.sis.repository.FacultyRepository;
import com.asteria_academy.sis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassSubjectService {

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    public List<ClassSubject> getAllClassSubjects() {
        return classSubjectRepository.findAll();
    }

    public Optional<ClassSubject> getClassSubjectById(Long id) {
        return classSubjectRepository.findById(id);
    }

    public List<ClassSubject> getClassesByFacultyId(Long facultyId) {
        return classSubjectRepository.findByFacultyId(facultyId);
    }

    public List<ClassSubject> getClassesByStudentId(Long studentId) {
        return classSubjectRepository.findByStudentsId(studentId);
    }

    public ClassSubject saveClassSubject(ClassSubject classSubject, Long facultyId) {
        Optional<Faculty> facultyOpt = facultyRepository.findById(facultyId);
        if (facultyOpt.isPresent()) {
            classSubject.setFaculty(facultyOpt.get());
            return classSubjectRepository.save(classSubject);
        } else {
            throw new RuntimeException("Faculty not found");
        }
    }

    public ClassSubject updateClassSubject(ClassSubject classSubject) {
        return classSubjectRepository.save(classSubject);
    }

    public void deleteClassSubject(Long id) {
        classSubjectRepository.deleteById(id);
    }

    public void updateStudentsInClassSubject(Long classSubjectId, Long[] studentsToAdd, Long[] studentsToRemove) {
        Optional<ClassSubject> classSubjectOpt = classSubjectRepository.findById(classSubjectId);
        if (classSubjectOpt.isPresent()) {
            ClassSubject classSubject = classSubjectOpt.get();

            // Remove students
            if (studentsToRemove != null) {
                for (Long studentId : studentsToRemove) {
                    Optional<Student> studentOpt = studentRepository.findById(studentId);
                    studentOpt.ifPresent(classSubject.getStudents()::remove);
                }
            }

            // Add students
            if (studentsToAdd != null) {
                for (Long studentId : studentsToAdd) {
                    Optional<Student> studentOpt = studentRepository.findById(studentId);
                    studentOpt.ifPresent(classSubject.getStudents()::add);
                }
            }

            classSubjectRepository.save(classSubject);
        } else {
            throw new RuntimeException("ClassSubject not found");
        }
    }

    public void addStudentToClassSubject(Long classSubjectId, Long studentId) {
        Optional<ClassSubject> classSubjectOpt = classSubjectRepository.findById(classSubjectId);
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (classSubjectOpt.isPresent() && studentOpt.isPresent()) {
            ClassSubject classSubject = classSubjectOpt.get();
            Student student = studentOpt.get();

            if (!classSubject.getStudents().contains(student)) {
                classSubject.getStudents().add(student);
                classSubjectRepository.save(classSubject);
            }
        } else {
            throw new RuntimeException("ClassSubject or Student not found");
        }
    }

    public void removeStudentFromClassSubject(Long classSubjectId, Long studentId) {
        Optional<ClassSubject> classSubjectOpt = classSubjectRepository.findById(classSubjectId);
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (classSubjectOpt.isPresent() && studentOpt.isPresent()) {
            ClassSubject classSubject = classSubjectOpt.get();
            Student student = studentOpt.get();

            classSubject.getStudents().remove(student);
            classSubjectRepository.save(classSubject);
        } else {
            throw new RuntimeException("ClassSubject or Student not found");
        }
    }
}
