package com.student.management.service.impl;

import com.student.management.DTO.StudentDto;
import com.student.management.model.Student;
import com.student.management.repository.StudentRepository;
import com.student.management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(StudentDto studentDto){
        Student student = new Student(studentDto.getName(), studentDto.getAge(), studentDto.getEmail());
        //JAVA EXTRA CODE
        studentRepository.save(student);
    }

    @Override
    public List<Student> showAllStudents() {
        List<Student> studentsList = studentRepository.findAll();

        return studentsList;
    }

    @Override
    public Student updateStudent(long id, StudentDto studentdto){


       // Geeting a Row with the mention id
        Optional<Student> st = studentRepository.findById(id);

        Student student = st.get();
        student.setAge(studentdto.getAge() == 0 ? st.get().getAge(): studentdto.getAge());
        student.setEmail(studentdto.getEmail() == null ? st.get().getEmail() :studentdto.getEmail());
        student.setName(studentdto.getName() == null ? st.get().getName() : studentdto.getName());

        studentRepository.save(student);
        return student;
    }
    @Override
    public Student deleteStudent(long id){
        Optional<Student> st = studentRepository.findById(id);
        Student student = st.get();
        studentRepository.delete(student);
        return student;
    }
}
