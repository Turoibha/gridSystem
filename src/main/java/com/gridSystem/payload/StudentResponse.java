package com.gridSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private List<StudentDto> students;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}

