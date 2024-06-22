package com.asteria_academy.sis.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    private String faculty_id;

    private String name;
    private String department;

    @OneToMany(mappedBy = "faculty")
    private Set<Subject> subjects;

    // Getters and setters
    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Set<Subject> getClasses() {
        return subjects;
    }

    public void setClasses(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
