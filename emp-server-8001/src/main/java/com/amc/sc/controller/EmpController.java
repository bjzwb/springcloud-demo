package com.amc.sc.controller;

import com.amc.sc.domin.Emp;
import com.amc.sc.service.EmpService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @HystrixCommand(
            commandKey = "queryAllEmp",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="3000"),
            },
            fallbackMethod = "queryAllEmpFallBack"
    )
    public List<Emp> queryAllEmp() {
        return empService.queryAllEmp();
    }


    public List<Emp> queryAllEmpFallBack(){
        ArrayList<Emp> emps = new ArrayList<>();
        Emp emp = new Emp().setTid(-1l).setEmpName("超时。。。").setDbSource("no database");
        emps.add(emp);
        return emps;

    }

    @GetMapping("/emp/get/{id}")
    @HystrixCommand(fallbackMethod = "queryEmpByIdFallBack")
    public Emp queryEmpById(@PathVariable("id") Long id) {
        Emp emp = empService.queryEmpById(id);
        if (emp == null){
            throw new RuntimeException("无此用户"+id);
        }
        return emp;
    }

    public Emp queryEmpByIdFallBack(Long id){
        return new Emp().setTid(-1l).setEmpName("无此用户"+id).setDbSource("no database");
    }

}
