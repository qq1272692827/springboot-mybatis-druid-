package com.ccsu.mysql.dao.write;

import com.ccsu.mysql.entity.StudentInfo;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("writeSqlSessionFactory")
public interface WriteStudentMapper {

    public void insert(StudentInfo studentInfo);

}
