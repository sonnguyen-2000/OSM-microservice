package com.codegym.cglmsauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CgLmsAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgLmsAuthServiceApplication.class, args);
    }

}
