package com.bibhu.springboot.recordmanagementapp01.service;

import com.bibhu.springboot.recordmanagementapp01.model.Employee;
import com.bibhu.springboot.recordmanagementapp01.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(long id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> findEmployeeByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> findAllEmployeeByStipend() {
        return employeeRepository.findAllEmployeeByStipend();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    public void updateEmployeeById(Employee employee, long id) {
        deleteEmployeeById(id);
        employeeRepository.save(employee);
    }


}
