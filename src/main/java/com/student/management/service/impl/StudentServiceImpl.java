package com.student.management.service.impl;

import com.student.management.DTO.StudentDto;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(StudentDto studentDto){
        Student student = new Student(studentDto.getName(), studentDto.getAge(), studentDto.getEmail());
        studentRepository.save(student);
    }

    @Override
    public List<Student> showAllStudents() {
        List<Student> studentsList = studentRepository.findAll();

        return studentsList;
    }
}
