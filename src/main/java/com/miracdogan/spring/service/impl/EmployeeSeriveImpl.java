package com.miracdogan.spring.service.impl;

import com.miracdogan.spring.exception.ResourceNotFoundException;
import com.miracdogan.spring.model.Employee;
import com.miracdogan.spring.repository.EmployeeRepository;
import com.miracdogan.spring.service.EmployeeSercive;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeSeriveImpl implements EmployeeSercive {

    private EmployeeRepository employeeRepository;

    public EmployeeSeriveImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //First check the employee
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        //Check employee exist in DB
        employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }
}
