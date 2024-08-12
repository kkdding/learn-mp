package com.ding.learnmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ding.learnmp.mapper")
public class LearnMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMpApplication.class, args);
    }

}
