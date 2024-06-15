package com.example.demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
Student saveStudent(Student st);
List<Student> getAllStudent();
Student getStudentById(int id);
Student updateStudent(Student st);
void deleteStudent(int id);
Page<Student>findAll(Pageable p);
}
