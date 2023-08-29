package com.bibhu.springboot.recordmanagementapp01.controller;

import com.bibhu.springboot.recordmanagementapp01.model.Employee;
import com.bibhu.springboot.recordmanagementapp01.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> findAllEmployee(){
        LOGGER.debug("EmployeeController Controller : fetch All records");
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employee/id/{id}")
    public Employee findEmployeeById(@PathVariable long id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/employee/name/{name}")
    public List<Employee> findEmployeeByName(@PathVariable String name){
        return employeeService.findEmployeeByName(name);
    }

    @GetMapping("/employee-stipend")
    public List<Employee> findAllEmployeeByStipend(){
        return employeeService.findAllEmployeeByStipend();
    }

    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable long id){
        employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/employee/{id}")
    public void updateEmployeeById(@RequestBody Employee employee, @PathVariable long id){
        employeeService.updateEmployeeById(employee, id);
    }



}
