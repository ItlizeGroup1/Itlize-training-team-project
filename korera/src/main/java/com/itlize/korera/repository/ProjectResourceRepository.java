package com.itlize.korera.repository;
import com.itlize.korera.entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer > {
    List<ProjectResource> findAllByPid(Integer Pid);
    String deleteAllByPid(Integer pid);
}
