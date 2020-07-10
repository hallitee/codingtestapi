package com.hallisoft.codingtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
@Controller
@RestController
@SpringBootApplication
@EnableJpaAuditing
public class CodingtaskApplication {

    @RequestMapping("/")
    String hello() {
        return "I am about to start";
    }
    public static void main(String[] args) {
        SpringApplication.run(CodingtaskApplication.class, args);
    }

}
