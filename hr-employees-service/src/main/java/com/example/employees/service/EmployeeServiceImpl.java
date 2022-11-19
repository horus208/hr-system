package com.example.employees.service;

import com.example.employees.dto.EmployeeFilter;
import com.example.employees.entity.Employee;
import com.example.employees.exception.ResourceNotFoundException;
import com.example.employees.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> filterEmployees(EmployeeFilter filter)
    {
        return employeeRepo.filterEmployees(filter.getFirstName(), filter.getLastName(),
                filter.getEmail(),filter.getStartHireDate(), filter.getLastHireDate(),
                filter.getStartSalary(),filter.getLastSalary(), filter.getJobName(), filter.getDepartmentName());
    }

    @Override
    public Employee getEmployeeById(Integer employeeId)
    {


            Optional<Employee> employee  = employeeRepo.findById(employeeId);
            if(employee.isEmpty())
                throw new ResourceNotFoundException("the employee you are trying to get by Id  = "
                        + employeeId + "does not exist");
            return employee.get();

    }

    @Override
    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }





}
