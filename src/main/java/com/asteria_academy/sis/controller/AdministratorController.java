package com.asteria_academy.sis.controller;

import com.asteria_academy.sis.entity.Administrator;
import com.asteria_academy.sis.entity.LogIn;
import com.asteria_academy.sis.security.algorithm.PasswordArgon2SpringSecurity;
import com.asteria_academy.sis.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators")
@CrossOrigin(origins = "http://localhost:5173")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/")
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        return new ResponseEntity<>(administratorService.getAllAdministrators(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long id) {
        return new ResponseEntity<>(administratorService.getAdministratorById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        PasswordArgon2SpringSecurity passwordSecurity = new PasswordArgon2SpringSecurity();
        String salt = passwordSecurity.generateSalt();
        String hashedPassword = passwordSecurity.encryptPassword(administrator.getPassword(), salt); // Assuming the raw password is in the 'hash' field

        administrator.setSalt(salt);
        administrator.setPassword(hashedPassword);
        Long lastID = administratorService.getLastInsertedId();
        String username = administratorService.username(lastID);
        administrator.setUsername(username);

        return new ResponseEntity<>(administratorService.saveAdministrator(administrator), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String login(@RequestBody LogIn loginRequest) {
        boolean isAuthenticated = administratorService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long id, @RequestBody Administrator administrator) {
        Administrator existingAdministrator = administratorService.getAdministratorById(id).orElse(null);
        if (existingAdministrator != null) {
            existingAdministrator.setEmail(administrator.getEmail());
            existingAdministrator.setPassword(administrator.getPassword());
            existingAdministrator.setSalt(administrator.getSalt());
            existingAdministrator.setFull_name(administrator.getFull_name());
            existingAdministrator.setAddress(administrator.getAddress());
            existingAdministrator.setGender(administrator.getGender());
            existingAdministrator.setMobile_number(administrator.getMobile_number());
            existingAdministrator.setRole(administrator.getRole());
            return new ResponseEntity<>(administratorService.updateAdministrator(existingAdministrator), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdministrator(@PathVariable Long id) {
        try {
            administratorService.deleteAdministrator(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}