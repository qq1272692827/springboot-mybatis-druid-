package com.ccsu.mysql.dao.read;

import com.ccsu.mysql.entity.StudentInfo;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier("readSqlSessionFactory")
public interface ReadStudentMapper {

    public List<StudentInfo> queryStudentList();


}
