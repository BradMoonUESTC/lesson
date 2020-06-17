package com.xy.lesson.controller;

import com.xy.lesson.common.api.CommonResult;
import com.xy.lesson.mbg.model.Student;
import com.xy.lesson.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping(value = "/listAll")
    @ResponseBody
    public CommonResult<List<Student>> getStuList() {
        return CommonResult.success(studentService.listAllStu());
    }

    @GetMapping(value="/stu/{id}")
    @ResponseBody
    public CommonResult<Student> getStuById(@PathVariable("id") Integer id){
        return CommonResult.success(studentService.getStuById(id));
    }

}
