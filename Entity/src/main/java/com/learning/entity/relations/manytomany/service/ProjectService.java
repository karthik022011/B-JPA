package com.learning.entity.relations.manytomany.service;

import com.learning.entity.relations.manytomany.model.Employee;
import com.learning.entity.relations.manytomany.model.Project;
import com.learning.entity.relations.manytomany.repository.EmployeeRepository;
import com.learning.entity.relations.manytomany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;


    public Project createProject(Project entity) {
        // save Employee
        Project  employee = projectRepository.save(entity);
        return employee;
    }

    public Project assignProjectToEmployees(Integer projId, Integer empId) {
        // get Employee
        Employee employee = employeeRepository.findById(empId).get();

        // Get Project
        Project project = this.projectRepository.findById(projId).get();

        // assign Employee to Project
        project.getEmployees().add(employee);

        // save Project
        Project savedProject = projectRepository.save(project);
        return  savedProject;

    }


    public Project getProject(Integer projId) {
        // get Project details
        Project project = projectRepository.findById(projId).get();
        return project;
    }
}
