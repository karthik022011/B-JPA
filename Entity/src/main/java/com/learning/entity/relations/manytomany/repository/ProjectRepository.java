package com.learning.entity.relations.manytomany.repository;

import com.learning.entity.relations.manytomany.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
