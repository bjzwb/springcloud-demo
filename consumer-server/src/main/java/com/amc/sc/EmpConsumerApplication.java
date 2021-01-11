package com.amc.sc;

import com.amc.sc.config.UiBlRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@RibbonClient(name = "SPRING-CLOUD-PROVIDER-EMP",configuration = UiBlRule.class)
@EnableFeignClients(basePackages = {"com.amc.sc"})
public class EmpConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpConsumerApplication.class);
    }
}
