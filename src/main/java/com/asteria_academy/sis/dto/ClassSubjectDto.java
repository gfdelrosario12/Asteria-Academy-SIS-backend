package com.asteria_academy.sis.dto;

public class ClassSubjectDto {

    private Long id;
    private String className;
    private int schoolYear;
    private int yearLevel;
    private int semester;
    private String program;
    private int block;

    // Constructor
    public ClassSubjectDto(Long id, String className, int schoolYear, int yearLevel, int semester, String program, int block) {
        this.id = id;
        this.className = className;
        this.schoolYear = schoolYear;
        this.yearLevel = yearLevel;
        this.semester = semester;
        this.program = program;
        this.block = block;
    }
    }