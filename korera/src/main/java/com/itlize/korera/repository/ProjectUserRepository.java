package com.itlize.korera.repository;

import com.itlize.korera.entity.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ProjectUserRepository extends JpaRepository<ProjectUser , Integer> {
    @Query(value = "select Pid from ProjectUser where Uid= ?1")
    List<Integer> findAllByUid(Integer Uid);
}
