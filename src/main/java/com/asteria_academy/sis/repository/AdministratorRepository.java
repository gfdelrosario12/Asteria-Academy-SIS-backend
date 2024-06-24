package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {
    // No need to define findAllAdmins since findAll is already provided by JpaRepository
}
