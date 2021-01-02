package com.amc.sc.controller;

import com.amc.sc.domin.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerEmpController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-PROVIDER-EMP";
    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @GetMapping("/consumer/emp/list")
    public List<Emp> queryAllEmp(){
        List<Emp> emps = restTemplate.getForObject(REST_URL_PREFIX + "/emp/list", List.class);
        return emps;
    }

    @GetMapping("/consumer/emp/get/{tid}")
    public Emp queryEmpByTid(@PathVariable("tid") Long tid){
        Emp emp = restTemplate.getForObject(REST_URL_PREFIX + "/emp/get/" + tid, Emp.class);
        return emp;
    }

    @PostMapping("/consumer/emp/add")
    public String addEmp(Emp emp){
        String s = restTemplate.postForObject(REST_URL_PREFIX + "/emp/add", emp, String.class);
        return s;

    }


}
