package com.increff.employee.service;

import com.increff.employee.dao.EmployeeInMemDao;
import com.increff.employee.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService1 {

    @Autowired
    EmployeeInMemDao employeeDao;

    public void init(){

    }


    public void addList(List<EmployeePojo> list) {
        for (EmployeePojo p : list) {
            employeeDao.insert(p);
        }
    }
}
