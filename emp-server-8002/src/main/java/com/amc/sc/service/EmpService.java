package com.amc.sc.service;

import com.amc.sc.domin.Emp;

import java.util.List;

public interface EmpService {
    /**
     * 新增
     *
     * @param emp
     * @return
     */
    int addEmp(Emp emp);

    /**
     * 查询全部
     *
     * @param
     * @return
     */
    List<Emp> queryAllEmp();

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    Emp queryEmpById(Long id);

}
