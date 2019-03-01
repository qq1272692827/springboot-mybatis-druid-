package com.ccsu.mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wenzhenyu
 * @description 返回消息
 * @date 2019/2/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

}
