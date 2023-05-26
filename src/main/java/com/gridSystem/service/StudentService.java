package com.gridSystem.service;

import com.gridSystem.payload.StudentDto;
import com.gridSystem.payload.StudentResponse;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentResponse getStudentsWithPaginationAndSorting(int pageNo, int pageSize, String sortBy, String sortDir);
    void addStudent(StudentDto studentDTO);

}

