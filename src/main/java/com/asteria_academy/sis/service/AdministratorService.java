package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Administrator;
import com.asteria_academy.sis.repository.AdministratorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;
    // Method to create an administrator
    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    // Method to retrieve an administrator by user_id
    public Optional<Administrator> getAdministratorById(String userId) {
        return administratorRepository.findById(userId);
    }

    // Method to retrieve all administrators using custom query
    public Optional<Administrator> getAllAdmins() {
        return administratorRepository.findAllAdmins();
    }

    // Method to update an existing administrator
    public Administrator updateAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    // Method to delete an administrator by user_id
    public void deleteAdministrator(String userId) {
        administratorRepository.deleteById(userId);
    }
}
