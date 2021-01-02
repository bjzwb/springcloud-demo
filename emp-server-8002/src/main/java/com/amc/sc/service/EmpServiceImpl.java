package com.amc.sc.service;

import com.amc.sc.domin.Emp;
import com.amc.sc.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public int addEmp(Emp emp) {

        return empMapper.addEmp(emp);
    }

    @Override
    public List<Emp> queryAllEmp() {
        return empMapper.queryAllEmp();
    }

    @Override
    public Emp queryEmpById(Long id) {
        return empMapper.queryEmpById(id);
    }
}
