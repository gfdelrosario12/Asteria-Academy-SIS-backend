package com.asteria_academy.sis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "class_subject")
public class Class_Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String className;
    private int school_year;
    private int year_level;
    private int semester;
    private String program;
    private int block;

    @ManyToOne
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSchool_year() {
        return school_year;
    }

    public void setSchool_year(int school_year) {
        this.school_year = school_year;
    }

    public int getYear_level() {
        return year_level;
    }

    public void setYear_level(int year_level) {
        this.year_level = year_level;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
