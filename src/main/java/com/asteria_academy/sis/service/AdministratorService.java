package com.asteria_academy.sis.service;

import com.asteria_academy.sis.entity.Administrator;
import com.asteria_academy.sis.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    // Method to create an administrator
    public Administrator createAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    // Method to retrieve an administrator by admin_id
    public Optional<Administrator> getAdministratorById(Long admin_id) {
        return administratorRepository.findById(String.valueOf(admin_id));
    }

    // Method to retrieve all administrators using custom query
    public List<Administrator> getAllAdmins() {
        return administratorRepository.findAll();
    }

    // Method to update an existing administrator
    public Administrator updateAdministrator(Administrator administrator) {
        return administratorRepository.save(administrator);
    }

    // Method to delete an administrator by admin_id
    public void deleteAdministrator(Long admin_id) {
        administratorRepository.deleteById(String.valueOf(admin_id));
    }
}
