package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Administrator;
import com.asteria_academy.sis.entity.Grade;
import com.asteria_academy.sis.entity.Subject;
import com.asteria_academy.sis.service.AdministratorService;
import com.asteria_academy.sis.service.GradesService;
import com.asteria_academy.sis.service.SubjectsService;
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
    public ResponseEntity<Administrator> getAllAdmins() {
        Optional<Administrator> administrators = administratorService.getAllAdmins();
        return administrators.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to retrieve an administrator by user_id
    @GetMapping("/{admin_id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable String userId) {
        Optional<Administrator> administrator = administratorService.getAdministratorById(userId);
        return administrator.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to update an existing administrator
    @PutMapping("/{admin_id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable String userId,
                                                             @RequestBody Administrator administrator) {
        if (!userId.equals(administrator.getAdmin_id())) {
            return ResponseEntity.badRequest().build();
        }
        Administrator updatedAdministrator = administratorService.updateAdministrator(administrator);
        return ResponseEntity.ok(updatedAdministrator);
    }

    // Endpoint to delete an administrator by user_id
    @DeleteMapping("/{admin_id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable String userId) {
        administratorService.deleteAdministrator(userId);
        return ResponseEntity.noContent().build();
    }
}
