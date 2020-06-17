package com.xy.lesson.service;

import com.xy.lesson.mbg.model.Student;

import java.util.List;


public interface StudentService {

    List<Student> listAllStu();

    Student getStuById(Integer id);
}
