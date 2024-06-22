package com.asteria_academy.sis.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_grades")
public class Grade {
    @Id
    public String grade_id;

    public String student_id;

    private int school_year;
    private int year_level;
    private int semester;
    private String program;

    @OneToOne
    @JoinColumn(name = "class_id_1")  // Foreign key column in Grade table for first class
    private Subject subject1;

    @OneToOne
    @JoinColumn(name = "class_id_2")  // Foreign key column in Grade table for second class
    private Subject subject2;

    @OneToOne
    @JoinColumn(name = "class_id_3")  // Foreign key column in Grade table for third class
    private Subject subject3;

    @OneToOne
    @JoinColumn(name = "class_id_4")  // Foreign key column in Grade table for third class
    private Subject subject4;

    @OneToOne
    @JoinColumn(name = "class_id_5")  // Foreign key column in Grade table for third class
    private Subject subject5;

    @OneToOne
    @JoinColumn(name = "class_id_6")  // Foreign key column in Grade table for third class
    private Subject subject6;

    @OneToOne
    @JoinColumn(name = "class_id_7")  // Foreign key column in Grade table for third class
    private Subject subject7;

    @OneToOne
    @JoinColumn(name = "class_id_8")  // Foreign key column in Grade table for third class
    private Subject subject8;

    @OneToOne
    @JoinColumn(name = "class_id_9")  // Foreign key column in Grade table for third class
    private Subject subject9;

    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
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

    public Subject getSubject1() {
        return subject1;
    }

    public void setSubject1(Subject subject1) {
        this.subject1 = subject1;
    }

    public Subject getSubject2() {
        return subject2;
    }

    public void setSubject2(Subject subject2) {
        this.subject2 = subject2;
    }

    public Subject getSubject3() {
        return subject3;
    }

    public void setSubject3(Subject subject3) {
        this.subject3 = subject3;
    }

    public Subject getSubject4() {
        return subject4;
    }

    public void setSubject4(Subject subject4) {
        this.subject4 = subject4;
    }

    public Subject getSubject5() {
        return subject5;
    }

    public void setSubject5(Subject subject5) {
        this.subject5 = subject5;
    }

    public Subject getSubject6() {
        return subject6;
    }

    public void setSubject6(Subject subject6) {
        this.subject6 = subject6;
    }

    public Subject getSubject7() {
        return subject7;
    }

    public void setSubject7(Subject subject7) {
        this.subject7 = subject7;
    }

    public Subject getSubject8() {
        return subject8;
    }

    public void setSubject8(Subject subject8) {
        this.subject8 = subject8;
    }

    public Subject getSubject9() {
        return subject9;
    }

    public void setSubject9(Subject subject9) {
        this.subject9 = subject9;
    }
}
