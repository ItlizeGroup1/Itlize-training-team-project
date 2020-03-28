package com.itlize.Korera.repositories;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer> {
    List<ProjectResource> findAllByProjectId(Project projectId);

}
