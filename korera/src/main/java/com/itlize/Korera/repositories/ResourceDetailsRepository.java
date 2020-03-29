package com.itlize.Korera.repositories;


import com.itlize.Korera.dbModels.ResourceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ResourceDetailsRepository extends JpaRepository<ResourceDetails,String> {
    void deleteByColumnName(String columnName);
    void deleteById(Integer rdid);
    Optional<ResourceDetails> findById(Integer rdid);
}
