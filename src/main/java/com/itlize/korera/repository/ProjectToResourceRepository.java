package com.itlize.korera.repository;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectToResource;
import com.itlize.korera.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectToResourceRepository extends JpaRepository<ProjectToResource, Integer> {
    public List<ProjectToResource> findByProjectAndResource(Project project, Resource resource);
    public List<ProjectToResource> findByProject(Project project);
}