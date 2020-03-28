package com.itlize.korera.repository;

import com.itlize.korera.entity.Columns;
import com.itlize.korera.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ColumnsRepository extends JpaRepository<Columns,Integer> {
    public List<Columns> findByProjectAndColumnName(Project project, String columnName);
}