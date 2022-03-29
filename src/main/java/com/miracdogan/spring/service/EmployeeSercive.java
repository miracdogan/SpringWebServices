package com.miracdogan.spring.service;

import com.miracdogan.spring.model.Employee;

import java.util.List;

public interface EmployeeSercive {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
