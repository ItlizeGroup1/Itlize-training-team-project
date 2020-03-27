package com.itlize.korera.repository;

import com.itlize.korera.entity.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectUserRepository extends JpaRepository<ProjectUser , Integer> {
    List<ProjectUser> findAllByUid(Integer Uid);
}
