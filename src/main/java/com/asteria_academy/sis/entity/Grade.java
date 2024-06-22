package com.asteria_academy.sis.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student_grades")
public class Grade {
    @Id
    public String grade_id;

    public String student_id;

    private String full_name;
}
