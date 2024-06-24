package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Administrator;
import com.asteria_academy.sis.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asteria-academy/admin")
public class AdminController {

    @Autowired
    private AdministratorService administratorService;

    // Endpoint to create a new administrator
    @PostMapping("/")
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        Administrator createdAdministrator = administratorService.createAdministrator(administrator);
        return new ResponseEntity<>(createdAdministrator, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all administrators
    @GetMapping("/all")
    public ResponseEntity<List<Administrator>> getAllAdmins() {
        List<Administrator> administrators = administratorService.getAllAdmins();
        if (administrators.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(administrators);
        }
    }

    // Endpoint to retrieve an administrator by admin_id
    @GetMapping("/{admin_id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long admin_id) {
        Optional<Administrator> administrator = administratorService.getAdministratorById(admin_id);
        return administrator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing administrator
    @PutMapping("/{admin_id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long admin_id,
                                                             @RequestBody Administrator updatedAdmin) {
        Optional<Administrator> existingAdminOpt = administratorService.getAdministratorById(admin_id);

        if (existingAdminOpt.isPresent()) {
            Administrator existingAdmin = existingAdminOpt.get();
            existingAdmin.setEmail(updatedAdmin.getEmail());
            existingAdmin.setHash(updatedAdmin.getHash());
            existingAdmin.setSalt(updatedAdmin.getSalt());
            existingAdmin.setFull_name(updatedAdmin.getFull_name());
            existingAdmin.setAddress(updatedAdmin.getAddress());
            existingAdmin.setGender(updatedAdmin.getGender());
            existingAdmin.setMobile_number(updatedAdmin.getMobile_number());
            existingAdmin.setRole(updatedAdmin.getRole());

            Administrator updatedAdministrator = administratorService.updateAdministrator(existingAdmin);
            return ResponseEntity.ok(updatedAdministrator);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete an administrator by admin_id
    @DeleteMapping("/{admin_id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long admin_id) {
        administratorService.deleteAdministrator(admin_id);
        return ResponseEntity.noContent().build();
    }
}