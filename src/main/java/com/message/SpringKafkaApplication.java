package com.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author wen.yang
 */
@SpringBootApplication(scanBasePackages = "com.message.**")
public class SpringKafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaApplication.class,args);
    }
}
