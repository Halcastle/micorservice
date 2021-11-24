package com.imooc.course;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ServiceApplication
 * @Description TODO
 * @Author pwang6
 * @Date 2021/11/2 10:16
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDubbo
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class,args);
    }
}
