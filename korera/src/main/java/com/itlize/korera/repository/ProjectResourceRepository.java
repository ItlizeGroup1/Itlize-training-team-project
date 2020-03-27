package com.itlize.korera.repository;
import com.itlize.korera.entity.ProjectResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer > {
    @Query(value = "select Rid from ProjectResource where Pid= ?1")
    List<Integer> findAllByPid(Integer Pid);
}
