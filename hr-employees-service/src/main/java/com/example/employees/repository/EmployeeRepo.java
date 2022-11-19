package com.example.employees.repository;

import com.example.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>
{
    @Query(nativeQuery = true,value = "select * from fn_public_filter_employee(?1,?2,?3,?4,?5,?6,?7,?8,?9);")
    public List<Employee> filterEmployees(String firstName, String lastName, String email,
                                          LocalDate startHireDate, LocalDate lastHireDate,
                                          Integer startSalary,Integer lastSalary,
                                          String jobName,String departmentName);

}
