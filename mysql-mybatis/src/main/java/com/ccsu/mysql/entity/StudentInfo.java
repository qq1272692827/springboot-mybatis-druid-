package com.ccsu.mysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description 学生信息
 * @date 2019/2/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo  implements Serializable {




    private String username;
    private int  age;


}
