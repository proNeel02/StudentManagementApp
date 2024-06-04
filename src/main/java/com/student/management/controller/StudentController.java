package com.student.management.controller;

import com.student.management.DTO.StudentDto;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

//    Adding New Student in the dataBase
    @PostMapping("/add")
   public String AddStudent(@RequestBody StudentDto studentDto){
        studentService.addStudent(studentDto);
       return "Student Created Successfully!";
    }

//    Getting all Student list from the database
    @GetMapping("/")
   public List<Student> getAllStudents() {
        return  studentService.showAllStudents();
   }

// Updating a Student => name, age, email fd
  @PostMapping("/update/{id}")
  public Map<String, Object> updateStudent(@PathVariable long id,@RequestBody StudentDto studentdto){

      Map<String, Object> map = new HashMap<>();

      map.put("Data:", studentService.updateStudent(id,studentdto));
      map.put("message : ", "student Update Successful");
      return map;
  }

  // Deleting Student with Specific id
    @PostMapping("/delete/{id}")
    public Map<String, Object> deleteStudent(@PathVariable long id){

        Map<String, Object> map = new HashMap<>();

        map.put("message: ", "student deleted successfully!!");
        map.put("data: ", studentService.deleteStudent(id));
        return  map;
    }


}




