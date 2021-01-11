package com.amc.sc.service;

import com.amc.sc.mapper.EmpMapper;
import com.amc.sc.domin.Emp;
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
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return empMapper.queryAllEmp();
    }

    @Override
    public Emp queryEmpById(Long id) {
        return empMapper.queryEmpById(id);
    }
}
