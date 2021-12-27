package com.increff.employee.service;

import com.increff.employee.dao.EmployeeDao;
import com.increff.employee.pojo.EmployeePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Transactional
    public void add(EmployeePojo p){
        normalize(p);
        employeeDao.insert(p);
    }


    @Transactional
    public void delete(int id){
        employeeDao.delete(id);
    }

    @Transactional
    public List<EmployeePojo> getAll(){
        return employeeDao.selectAll();
    }

    @Transactional(rollbackOn = ApiException.class)
    public EmployeePojo get(int id) throws ApiException {
        EmployeePojo p = getCheck(id);
        return p;
    }

    @Transactional(rollbackOn = ApiException.class)
    public void update(EmployeePojo p) throws ApiException {
        normalize(p);
        EmployeePojo ex = getCheck(p.getId());
        ex.setAge(p.getAge());
        ex.setName(p.getName());
        employeeDao.update(p.getId(), p);
    }

    @Transactional
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
