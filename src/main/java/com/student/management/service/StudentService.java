package com.student.management.service;

import com.student.management.DTO.StudentDto;
import com.student.management.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public void addStudent(StudentDto studentDto);
    public List<Student> showAllStudents();
}
