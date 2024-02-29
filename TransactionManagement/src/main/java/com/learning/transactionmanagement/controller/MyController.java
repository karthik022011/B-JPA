package com.learning.transactionmanagement.controller;

import com.learning.transactionmanagement.entity.Employee;
import com.learning.transactionmanagement.model.EmployeeReqDTO;
import com.learning.transactionmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public void saveEmployee(@RequestBody EmployeeReqDTO employeeReqDTO) throws Exception{
        this.employeeService.addEmployee(employeeReqDTO);
      //  return new ResponseEntity<Employee>(employeeSavedToDB, HttpStatus.CREATED);
    }
}
