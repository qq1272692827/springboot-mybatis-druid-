package com.ccsu.mysql.controller;

import com.ccsu.mysql.dto.Message;
import com.ccsu.mysql.entity.StudentInfo;
import com.ccsu.mysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/2/27
 */
@RestController
public class TestController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/test")
    public String test(@RequestParam String username,@RequestParam int age){

        studentService.insertStudent(new StudentInfo(username,age));

       return "hello world";
    }

    @RequestMapping("/query")
    public Message query(){
        List<StudentInfo> studentInfos = studentService.queryStudentList();
        System.out.println("具体值"+studentInfos);
        return new Message(0,"success",studentInfos);
    }


}
