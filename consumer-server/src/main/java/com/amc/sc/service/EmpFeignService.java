package com.amc.sc.service;

import com.amc.sc.domin.Emp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value = "SPRING-CLOUD-PROVIDER-EMP",fallbackFactory = EmpServiceFallBackFactory.class)
public interface EmpFeignService {

    @PostMapping("/emp/add")
    int addEmp(Emp emp);

    @GetMapping("/emp/list")
    List<Emp> queryAllEmp();

    @GetMapping("/emp/get/{id}")
    Emp queryEmpById(@PathVariable("id")Long id);
}
