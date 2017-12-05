package com.denghb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(Application.class, args);
        System.out.println("http://localhost:8080/swagger-ui.html");
    }
}
