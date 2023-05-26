package com.gridSystem.service.impl;

import com.gridSystem.entity.Student;
import com.gridSystem.payload.StudentDto;
import com.gridSystem.payload.StudentResponse;
import com.gridSystem.repository.StudentRepository;
import com.gridSystem.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private  StudentRepository studentRepository;
    private ModelMapper modelMapper;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentResponse getStudentsWithPaginationAndSorting(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort );
        Page<Student> students = studentRepository.findAll(pageable);
        List<StudentDto> studentDTOs = students.map(student -> modelMapper.map(student, StudentDto.class)).toList();
        return new StudentResponse(studentDTOs, students.getNumber(), students.getSize(),
                students.getTotalElements(), students.getTotalPages());
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
    }
}
