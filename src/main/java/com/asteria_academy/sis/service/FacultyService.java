package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Faculty;
import com.asteria_academy.sis.repository.FacultyRepository;
import com.asteria_academy.sis.security.algorithm.PasswordArgon2SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    private final PasswordArgon2SpringSecurity passwordEncoder = new PasswordArgon2SpringSecurity();

    public boolean login(String email, String rawPassword) {
        Faculty faculty = facultyRepository.findByEmail(email);
        if (faculty != null) {
            String salt = faculty.getSalt();
            String hash = faculty.getPassword();
            return passwordEncoder.matchPasswords(salt, rawPassword, hash);
        }
        return false;
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.findById(id);
    }

    public Faculty saveFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
