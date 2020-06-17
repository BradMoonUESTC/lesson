package com.xy.lesson.service.impl;

import com.github.pagehelper.PageHelper;
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

    @Override
    public int createStu(Student student) {
        System.out.println("新增学生");
        return studentMapper.insertSelective(student);

    }

    /**
     * 通过主键id更新学生信息
     * @param id 学生id
     * @param student 学生实例
     * @return 0为失败，1为成功
     */
    @Override
    public int updateStu(Integer id, Student student) {
        System.out.println("修改学生，id为："+id);
        student.setId(id);
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    public int deleteStu(Integer id) {
        System.out.println("删除学生，id为："+id);
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Student> listStu(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return studentMapper.selectByExample(new StudentExample());

    }
}
