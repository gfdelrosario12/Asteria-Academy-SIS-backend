package com.asteria_academy.sis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false)
    private Class_Subject classSubjectObj;

    private int school_year;
    private int year_level;
    private int semester;
    private String program;
    private int block;

    @Column(nullable = false)
    private int grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class_Subject getClassSubjectObj() {
        return classSubjectObj;
    }

    public void setClassSubjectObj(Class_Subject classSubjectObj) {
        this.classSubjectObj = classSubjectObj;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}