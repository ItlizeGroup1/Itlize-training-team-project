package com.itlize.korera.service.imp;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.ResourceColumns;
import com.itlize.korera.entity.ResourceDetails;
import com.itlize.korera.repository.ResourceColumnsRepository;
import com.itlize.korera.service.ResourceColumnsService;
import com.itlize.korera.service.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResourceColumnsServiceImp implements ResourceColumnsService {

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