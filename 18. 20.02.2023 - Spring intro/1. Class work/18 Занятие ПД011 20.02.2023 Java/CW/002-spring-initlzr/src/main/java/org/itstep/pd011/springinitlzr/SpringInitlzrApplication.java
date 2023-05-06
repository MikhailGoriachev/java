package org.itstep.pd011.springinitlzr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInitlzrApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringInitlzrApplication.class, args);
        System.out.println("Привет, Spring!");
    }

}
