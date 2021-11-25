package com.imooc.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ServiceApplication
 * @Description TODO
 * @Author pwang6
 * @Date 2021/11/2 10:16
 * @Version 1.0
 **/
@SpringBootApplication
@EnableZuulProxy
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class,args);
    }
}
