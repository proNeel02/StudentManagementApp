package com.student.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;
    private String email;


    public Student( String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //Default Constructor
    public Student(){}


}
