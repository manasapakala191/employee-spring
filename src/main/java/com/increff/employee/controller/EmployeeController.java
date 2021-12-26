package com.increff.employee.controller;

import com.increff.employee.model.EmployeeData;
import com.increff.employee.pojo.EmployeePojo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.increff.employee.model.EmployeeForm;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Api
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Adds an employee")
    @RequestMapping(path = "/api/employee", method = RequestMethod.POST)
    public void addEmployee(@RequestBody EmployeeForm employeeForm) {
        EmployeePojo p = convert(employeeForm);
        employeeService.add(p);
    }

    @ApiOperation(value = "Updates an employee")
    @RequestMapping(path = "/api/employee/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable int id, @RequestBody EmployeeForm employeeForm) throws ApiException {
        EmployeePojo p = convert(employeeForm);
        p.setId(id);
        employeeService.update(p);
    }

    @ApiOperation(value = "Deletes an employee")
    @RequestMapping(path = "/api/employee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable int id) throws ApiException {
        employeeService.delete(id);
    }

    @ApiOperation(value = "Gets an employee")
    @RequestMapping(path = "/api/employee/{id}", method = RequestMethod.GET)
    public EmployeeData getEmployee(@PathVariable int id) throws ApiException {
        EmployeePojo p = employeeService.get(id);
        EmployeeData employeeData = convert(p);
        return employeeData;
    }

    @ApiOperation(value = "Gets all employee")
    @RequestMapping(path = "/api/employee", method = RequestMethod.GET)
    public List<EmployeeData> getEmployee() throws ApiException {
        List<EmployeePojo> list = employeeService.getAll();
        ArrayList<EmployeeData> employeeData = new ArrayList<EmployeeData>();
        for(EmployeePojo p : list){
            employeeData.add(convert(p));
        }
        return employeeData;
    }


    private static EmployeePojo convert(EmployeeForm employeeForm){
        EmployeePojo p = new EmployeePojo();
        p.setAge(employeeForm.getAge());
        p.setName(employeeForm.getName());
        return p;
    }

    private static EmployeeData convert(EmployeePojo p){
        EmployeeData employeeData = new EmployeeData();
        employeeData.setName(p.getName());
        employeeData.setAge(p.getAge());
        employeeData.setId(p.getId());
        return employeeData;
    }

}
