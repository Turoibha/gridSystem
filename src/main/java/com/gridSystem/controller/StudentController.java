package com.gridSystem.controller;

import com.gridSystem.payload.StudentDto;
import com.gridSystem.payload.StudentResponse;
import com.gridSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //http://localhost:8080/api/students?pageNo=0&pageSize=2&sortBy=id&sortDir=asc
    @GetMapping
    public ResponseEntity<StudentResponse> getStudents(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        StudentResponse studentResponse = studentService.getStudentsWithPaginationAndSorting(pageNo, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(studentResponse);
    }



    //http://localhost:8080/api/students
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return ResponseEntity.ok("Student added successfully");
    }

}
