package com.increff.employee.service;

import com.increff.employee.dao.EmployeeDao;
import com.increff.employee.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public void add(EmployeePojo p){
        normalize(p);
        employeeDao.insert(p);
    }


    public void delete(int id){
        employeeDao.delete(id);
    }

    public List<EmployeePojo> getAll(){
        return employeeDao.selectAll();
    }

    public EmployeePojo get(int id) throws ApiException {
        EmployeePojo p = getCheck(id);
        return p;
    }

    public void update(EmployeePojo p) throws ApiException {
        normalize(p);
        getCheck(p.getId());
        employeeDao.update(p.getId(), p);
    }
    public EmployeePojo getCheck(int id) throws ApiException {
        EmployeePojo p = employeeDao.select(id);
        if(p == null){
            throw new ApiException("Employee with given ID doesn't exist: "+id);
        }
        return p;
    }
    private static void normalize(EmployeePojo p) {
        p.setName(p.getName().toLowerCase().trim());
    }
}
