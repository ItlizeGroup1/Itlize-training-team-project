package com.itlize.korera.repository;

import com.itlize.korera.entity.Columns;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails,Integer> {
    List<ResourceDetails> findByResource(Resource resource);
    List<ResourceDetails> findByResourceAndColumn(Resource resource, Columns column);
}