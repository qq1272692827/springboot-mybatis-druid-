package com.ccsu.mysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wenzhenyu
 * @description 启动项目
 * @date 2019/2/27
 */
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
public class DBApplication  {

    public static void main(String[] args){

        SpringApplication.run(DBApplication.class,args);
    }
}
