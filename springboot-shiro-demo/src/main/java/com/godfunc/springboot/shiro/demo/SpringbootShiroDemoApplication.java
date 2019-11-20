package com.godfunc.springboot.shiro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class SpringbootShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShiroDemoApplication.class, args);
    }

}
