package com.reusehive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication()
@EnableCaching
@MapperScan("com.reusehive.mapper")
public class ReusehiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReusehiveApplication.class, args);
    }
}
