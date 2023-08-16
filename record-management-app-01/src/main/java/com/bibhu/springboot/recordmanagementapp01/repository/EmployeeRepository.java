package com.bibhu.springboot.recordmanagementapp01.repository;

import com.bibhu.springboot.recordmanagementapp01.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

    @Query("FROM Employee e where e.stipend > 1000")
    List<Employee> findAllEmployeeByStipend();
}
