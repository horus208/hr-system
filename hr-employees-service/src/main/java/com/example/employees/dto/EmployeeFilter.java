package com.example.employees.dto;

import java.time.LocalDate;

public class EmployeeFilter {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate startHireDate;
    private LocalDate lastHireDate;
    private Integer startSalary;
    private Integer lastSalary;
    private String jobName;
    private String departmentName;

    public EmployeeFilter() {}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getStartHireDate() {
        return startHireDate;
    }

    public LocalDate getLastHireDate() {
        return lastHireDate;
    }

    public Integer getStartSalary() {
        return startSalary;
    }

    public Integer getLastSalary() {
        return lastSalary;
    }

    public String getJobName() {
        return jobName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
