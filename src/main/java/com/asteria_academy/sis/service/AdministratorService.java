package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Administrator;
import com.asteria_academy.sis.repository.AdministratorRepository;
import com.asteria_academy.sis.security.algorithm.PasswordArgon2SpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    private PasswordArgon2SpringSecurity passwordEncoder = new PasswordArgon2SpringSecurity();

    public boolean login(String email, String rawPassword) {
        Administrator admin = administratorRepository.findByEmail(email);
        if (admin != null) {
            String salt = admin.getSalt();
            String hash = admin.getPassword();
            return passwordEncoder.matchPasswords(salt, rawPassword, hash);
        }
        return false;
    }

    public Long getLastInsertedId() {
        // Assuming your id field is Long and auto-generated
        // You can fetch the last inserted id by sorting in descending order
        List<Administrator> entities = administratorRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

        if (!entities.isEmpty()) {
            return entities.get(0).getId();
        } else {
            return null; // or handle accordingly if no entities are found
        }
    }

    public String username(Long lastID) {
        String role = "Administrator";
        return "AA " + role + " " + lastID;
    }

    public List<Administrator> getAllAdministrators() {
        return administratorRepository.findAll();
    }

    public Optional<Administrator> getAdministratorById(Long id) {
        return administratorRepository.findById(id);
    }

    public Administrator saveAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public Administrator updateAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    public void deleteAdministrator(Long id) {
        administratorRepository.deleteById(id);
    }
}
