package com.miracdogan.spring.controller;

import com.miracdogan.spring.model.Employee;
import com.miracdogan.spring.service.EmployeeSercive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeSercive employeeSercive;

    public EmployeeController(EmployeeSercive employeeSercive) {
        this.employeeSercive = employeeSercive;
    }

    //Create Employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeSercive.saveEmployee(employee), HttpStatus.CREATED);
    }

    //GET All Employee REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeSercive.getAllEmployee();
    }

    //GET Employee BY ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeSercive.getEmployeeById(employeeId), HttpStatus.OK);
    }

    //UPDATE Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeSercive.updateEmployee(employee, id), HttpStatus.OK);

    }

    //DELETE Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeSercive.deleteEmployee(id);

        return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
    }
}
