package com.learning.entity.relations.manytomany.controller;


import com.learning.entity.relations.manytomany.model.Project;
import com.learning.entity.relations.manytomany.service.EmployeeService;
import com.learning.entity.relations.manytomany.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("/createProject")
    public ResponseEntity<Project> createProject(@RequestBody Project entity) {
        // save Project
        Project project = projectService.createProject(entity);
        return ResponseEntity.ok(project);
    }

    @PostMapping("/assignProjectToEmployees/{projId}/{empId}")
    public ResponseEntity<Project> assignProjectToEmployees(@PathVariable(name = "projId") Integer projId,
                                           @PathVariable(name = "empId") Integer empId) {

        Project project = projectService.assignProjectToEmployees(projId, empId);
        return ResponseEntity.ok(project);
    }

    @GetMapping(value = "/getProject/{projId}")
    public ResponseEntity<Project> getProject(@PathVariable(name = "projId") Integer projId) {
        Project project = projectService.getProject(projId);
        return ResponseEntity.ok(project);
    }

}
