package com.ccsu.mysql.service;

import com.ccsu.mysql.entity.StudentInfo;

import java.util.List;
import java.util.Map;

public interface StudentService {

    public void insertStudent(StudentInfo studentInfo);

    public List<StudentInfo> queryStudentList();

}
