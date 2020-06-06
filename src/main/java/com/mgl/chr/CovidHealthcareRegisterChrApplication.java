package com.mgl.chr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CovidHealthcareRegisterChrApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidHealthcareRegisterChrApplication.class, args);
    }


}
