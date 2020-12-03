package com.bjpowernode.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan(basePackages="com.bjpowernode.auth.mapper")
@ImportResource("spring-shiro.xml")
public class SpringbootAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAuthApplication.class, args);
    }

}
