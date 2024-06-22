package com.asteria_academy.sis.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "administrator")
public class Administrator {
    @Id
    private String user_id;

    private String email;
    private String hash;
    private String salt;
    private String full_name;
    private String address;
    private char gender;
    private int mobile_number;
    private String role;
}
