package com.codegym.cglmsconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CgLmsConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CgLmsConfigServiceApplication.class, args);
    }

}
