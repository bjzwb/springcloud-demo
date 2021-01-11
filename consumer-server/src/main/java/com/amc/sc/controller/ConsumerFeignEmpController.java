package com.amc.sc.controller;

import com.amc.sc.domin.Emp;
import com.amc.sc.service.EmpFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerFeignEmpController {
    @Autowired
    private EmpFeignService empFeignService;

    @GetMapping("/consumer/emp/list")
    public List<Emp> queryAllEmp() {
        List<Emp> emps = empFeignService.queryAllEmp();
        return emps;
    }

    @GetMapping("/consumer/emp/get/{tid}")
    public Emp queryEmpByTid(@PathVariable("tid") Long tid) {
        Emp emp = empFeignService.queryEmpById(tid);
        return emp;
    }

    @PostMapping("/consumer/emp/add")
    public String addEmp(Emp emp) {
        int i = empFeignService.addEmp(emp);
        return i + "";
    }


}
