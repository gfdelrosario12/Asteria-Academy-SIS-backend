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

}
