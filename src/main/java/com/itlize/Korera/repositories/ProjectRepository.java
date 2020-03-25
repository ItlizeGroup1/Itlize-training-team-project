package com.itlize.Korera.repositories;

import com.itlize.Korera.dbModels.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
