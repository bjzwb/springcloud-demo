package com.amc.sc.mapper;

import com.amc.sc.domin.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpMapper {

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
