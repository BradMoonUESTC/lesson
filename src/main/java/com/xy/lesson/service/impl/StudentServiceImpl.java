package com.xy.lesson.service.impl;

import com.xy.lesson.mbg.mapper.StudentMapper;
import com.xy.lesson.mbg.model.Student;
import com.xy.lesson.mbg.model.StudentExample;
import com.xy.lesson.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public List<Student> listAllStu() {
        System.out.println("查询所有学生");
        List<Student> studentList=studentMapper.selectByExample(new StudentExample());
        return studentList;
    }

    @Override
    public Student getStuById(Integer id) {
        System.out.println("查询id为"+id+"的学生");
        Student student=studentMapper.selectByPrimaryKey(id);
        return student;
    }
}
