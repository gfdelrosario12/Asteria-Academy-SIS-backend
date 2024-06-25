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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}