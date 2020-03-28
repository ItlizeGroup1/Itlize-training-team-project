package com.itlize.Korera.repositories;

import com.itlize.Korera.dbModels.ResourceColumns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceColumnsRepository extends JpaRepository<ResourceColumns,Integer> {
    public List<ResourceColumns> findByColumnName(String columnName);
}
