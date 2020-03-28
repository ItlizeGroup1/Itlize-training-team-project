package com.itlize.korera.repository;


import com.itlize.korera.entity.ResourceColumns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceColumnsRepository extends JpaRepository<ResourceColumns,Integer> {
    public List<ResourceColumns> findByColumnName(String columnName);
}