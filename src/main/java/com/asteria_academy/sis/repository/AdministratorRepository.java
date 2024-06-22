package com.asteria_academy.sis.repository;

import com.asteria_academy.sis.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {
    @Query("SELECT a FROM Administrator a")
    Optional<Administrator> findAllAdmins();
}
