package com.xy.lesson.service;

import com.xy.lesson.mbg.model.Student;

import java.util.List;


public interface StudentService {

    List<Student> listAllStu();

    Student getStuById(Integer id);

    int createStu(Student student);

    int updateStu(Integer id, Student student);

    int deleteStu(Integer id);

    List<Student> listStu(int pageNum, int pageSize);
}
