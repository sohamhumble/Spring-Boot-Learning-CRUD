package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer Id);

    List<Student> findAll();

    List<Student> findByFirstName(String firstName);

    void update(Student student);

    void deleteById(Integer id);

    int deleteAll();
}
