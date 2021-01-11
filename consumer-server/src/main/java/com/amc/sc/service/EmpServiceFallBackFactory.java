package com.amc.sc.service;

import com.amc.sc.domin.Emp;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpServiceFallBackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new EmpFeignService() {
            @Override
            public int addEmp(Emp emp) {
                return 0;
            }

            @Override
            public List<Emp> queryAllEmp() {
                ArrayList<Emp> emps = new ArrayList<>();
                Emp emp = new Emp().setTid(-1l).setEmpName("访问的服务已关闭，降级处理").setDbSource("no database");
                emps.add(emp);
                return emps;
            }

            @Override
            public Emp queryEmpById(Long id) {
                return null;
            }
        };
    }
}
