package com.amc.sc.controller;

import com.amc.sc.domin.Emp;
import com.amc.sc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/emp/add")
    public String addEmp(Emp emp) {
        int i = empService.addEmp(emp);
        return i+"";
    }

    @GetMapping("/emp/list")
    public List<Emp> queryAllEmp() {
        return empService.queryAllEmp();
    }

    @GetMapping("/emp/get/{id}")
    public Emp queryEmpById(@PathVariable("id") Long id) {
        return empService.queryEmpById(id);
    }
}
