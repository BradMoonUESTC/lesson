package com.xy.lesson.controller;

import ch.qos.logback.classic.spi.STEUtil;
import com.xy.lesson.common.api.CommonResult;
import com.xy.lesson.mbg.model.Student;
import com.xy.lesson.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

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

    @PostMapping(value = "/create")
    @ResponseBody
    public CommonResult<Student> createStu(@RequestBody Student student) {
        CommonResult commonResult;
        int count = studentService.createStu(student);
        if (count == 1) {
            commonResult = CommonResult.success(student);
            LOGGER.debug("createStudent success:{}", student);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createStudent failed:{}", student);
        }
        return commonResult;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Student> updateStu(@PathVariable Integer id, @RequestBody Student student, BindingResult result){
        CommonResult commonResult;
            int count = studentService.updateStu(id, student);
        if (count == 1) {
            student=studentService.getStuById(id);
            commonResult = CommonResult.success(student);
            LOGGER.debug("updateStudent success:{}", student);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateStudent failed:{}", student);
        }

        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Integer id) {
        int count = studentService.deleteStu(id);
        if (count == 1) {
            LOGGER.debug("deleteStudent success :id={}", id);
            return CommonResult.success(null);
        } else {
            LOGGER.debug("deleteStudent failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

}
