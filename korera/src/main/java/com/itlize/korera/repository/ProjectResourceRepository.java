package com.itlize.korera.repository;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer > {
    List<ProjectUser> findAllByPid(Integer Pid);
}
