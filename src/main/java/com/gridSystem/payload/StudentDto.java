package com.gridSystem.payload;

import lombok.Data;

import javax.persistence.Column;
@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private int totalMarks;
}
