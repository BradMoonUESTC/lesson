package com.xy.lesson.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.xy.lesson.mapper")
class DemoApplicationTests {

//    @Test
//    public static void main(String[] args) {
//        SpringApplication.run(.class, args);
//    }

    @Test
    void contextLoads() {
    }

}
