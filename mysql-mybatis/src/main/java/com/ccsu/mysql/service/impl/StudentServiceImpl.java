package com.ccsu.mysql.service.impl;

import com.ccsu.mysql.dao.read.ReadStudentMapper;
import com.ccsu.mysql.dao.write.WriteStudentMapper;
import com.ccsu.mysql.entity.StudentInfo;
import com.ccsu.mysql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author wenzhenyu
 * @description
 * @date 2019/2/28
 */
@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    private WriteStudentMapper writeStudentMapper;

    @Autowired
    private ReadStudentMapper readStudentMapper;

    public void insertStudent(StudentInfo studentInfo){

        writeStudentMapper.insert(studentInfo);
    }


    public List<StudentInfo> queryStudentList(){
        return readStudentMapper.queryStudentList();

    }




}
