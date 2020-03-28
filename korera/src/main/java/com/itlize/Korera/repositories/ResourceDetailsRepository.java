package com.itlize.Korera.repositories;


import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails,Integer> {
    List<ResourceDetails> findByResource(Resource resource);
    List<ResourceDetails> findByResourceAndColumnName(Resource resource,String columnName);

}
