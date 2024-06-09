package com.learning.entity.relations.manytomany.controller;

import com.learning.entity.relations.manytomany.model.Employee;
import com.learning.entity.relations.manytomany.service.EmployeeService;
import com.learning.entity.relations.manytomany.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee entity) {
        Employee savedEmployee = employeeService.createEmployee(entity);
        return ResponseEntity.ok(savedEmployee);
    }

    @PostMapping(value = "/createEmployeeForProject/{projId}")
    public ResponseEntity<Employee> createEmployeeForProject(@RequestBody Employee entity,
                                           @PathVariable(name = "projId") String projId) {
        Employee savedEmployee = employeeService.createEmployeeForProject(entity, projId);
        return ResponseEntity.ok(savedEmployee);
    }


    @GetMapping(value = "/getEmployee/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "empId") Integer empId) {
        Employee employeeDetails = employeeService.getEmployee(empId);
        return ResponseEntity.ok(employeeDetails);
    }
}
