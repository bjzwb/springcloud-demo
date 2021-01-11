package com.amc.sc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmpProvider8002Application {

    public static void main(String[] args) {
        SpringApplication.run(EmpProvider8002Application.class, args);
    }

}
