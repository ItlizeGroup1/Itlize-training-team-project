package com.itlize.Korera.services.serviceImpl;


import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceColumns;
import com.itlize.Korera.dbModels.ResourceDetails;
import com.itlize.Korera.repositories.ResourceColumnsRepository;
import com.itlize.Korera.services.ResourceColumnsService;
import com.itlize.Korera.services.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResourceColumnsServiceImpl implements ResourceColumnsService {
    @Autowired
    ResourceDetailsService resourceDetailsService;

    @Autowired
    ResourceColumnsRepository resourceColumnsRepository;

    @Override
    public boolean create(ResourceColumns resourceColumns) {
        List<ResourceColumns> ret = resourceColumnsRepository.findByColumnName(resourceColumns.getColumnName());
        if(ret.size()>0){
            System.out.println(String.format("column %s exist",resourceColumns.getColumnName()));
            return false;
        }
        try{
            resourceColumnsRepository.save(resourceColumns);
        }catch (Exception e){
            System.out.println("Sth wrong happens when creating column "+ resourceColumns.getColumnName());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ResourceColumns resourceColumns) {
        try{
            resourceColumnsRepository.delete(resourceColumns);
        }catch (Exception e){
            System.out.println("Sth wrong happens when deleting column "+ resourceColumns.getColumnName());
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean update(String columnName, String newColumnName) {
        ResourceColumns target = get(columnName);
        List<ResourceDetails> relatedEntries = resourceDetailsService.get(columnName);
        for(ResourceDetails rd : relatedEntries){
            rd.setColumnName(newColumnName);
            resourceDetailsService.update(rd);
        }
        target.setColumnName(newColumnName);
        return true;
    }

    @Override
    public ResourceColumns get(String columnName) {
        List<ResourceColumns> ret = resourceColumnsRepository.findByColumnName(columnName);
        if(ret.size()==0){
            return null;
        }
        return ret.get(0);
    }
}
