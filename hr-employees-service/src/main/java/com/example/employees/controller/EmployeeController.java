package com.example.employees.controller;

import com.example.employees.dto.EmployeeFilter;
import com.example.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/employees/")
public class EmployeeController
{
   EmployeeService employeeService;

   @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/search")
    public ResponseEntity<?> filterEmployees(@RequestBody EmployeeFilter filter)
    {
        return new ResponseEntity<>(employeeService.filterEmployees(filter), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<?> getAllEmployees(Pageable pageable)
    {

        return new ResponseEntity<>(employeeService.getAllEmployees(pageable),HttpStatus.OK);
    }
    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable Integer employeeId)
    {

        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

}
