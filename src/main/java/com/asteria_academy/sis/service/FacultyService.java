package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Faculty;
import com.asteria_academy.sis.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // Method to create a faculty member
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Method to retrieve all faculty members
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    // Method to retrieve a faculty member by faculty_id
    public Optional<Faculty> getFacultyById(String facultyId) {
        return facultyRepository.findById(facultyId);
    }

    // Method to retrieve all faculty members using custom query
    public Optional<Faculty> getAllFacultyCustomQuery() {
        return facultyRepository.findAllFaculty();
    }

    // Method to update an existing faculty member
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    // Method to delete a faculty member by faculty_id
    public void deleteFaculty(String facultyId) {
        facultyRepository.deleteById(facultyId);
    }
}
