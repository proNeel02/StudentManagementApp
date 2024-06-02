package com.student.management.controller;

import com.student.management.DTO.StudentDto;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {



    @Autowired
    StudentService studentService;

    @PostMapping("/add")
   public String AddStudent(@RequestBody StudentDto studentDto){
        studentService.addStudent(studentDto);
       return "Student Created Successfully!";
    }

    @GetMapping("/")
   public List<Student> getAllStudents() {
        return  studentService.showAllStudents();
   }
}


