package com.example.employees.service;

import com.example.employees.dto.EmployeeFilter;
import com.example.employees.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService
{
     List<Employee> filterEmployees(EmployeeFilter filter);
     Employee getEmployeeById(Integer employeeId);
     Page<Employee> getAllEmployees(Pageable pageable);





}
