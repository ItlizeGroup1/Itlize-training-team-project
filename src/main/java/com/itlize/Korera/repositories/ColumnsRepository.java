package com.itlize.Korera.repositories;

import com.itlize.Korera.dbModels.Columns;
import com.itlize.Korera.dbModels.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColumnsRepository extends JpaRepository<Columns,Integer> {
    public List<Columns> findByProjectAndColumnName(Project project, String columnName);
}
