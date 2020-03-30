package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Resource;
import com.itlize.Korera.dbModels.ResourceDetails;
import com.itlize.Korera.repositories.ResourceDetailsRepository;
import com.itlize.Korera.repositories.ResourceRepository;
import com.itlize.Korera.services.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResourceDetailsServiceImpl implements ResourceDetailsService {

    @Autowired
    private ResourceDetailsRepository resourceDetailsRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public String create(Integer rid, String columnName, String columnValue) {
        Optional<Resource> op = resourceRepository.findById(rid);
        if (op.isPresent()) {
            Resource r = op.get();
            ResourceDetails rd = new ResourceDetails();
            rd.setResource(r);
            rd.setColumnValue(columnValue);
            rd.setColumnName(columnName);
            resourceDetailsRepository.save(rd);
            return "Resource: " + rid + "-" + columnName + " : " + columnValue + " has been created!";
        } else return "failed";
    }
    @Override
    public String deleteCol(String columnName){
        try{
            resourceDetailsRepository.deleteByColumnName(columnName);
            return "Column: "+columnName+" has been deleted!";
        }catch (Exception e){
            e.getStackTrace();
            return "failed!";
        }
    }
    @Override
    public String update(Integer rdid, String columnValue) {
        if (columnValue == "") {
            resourceDetailsRepository.deleteById(rdid);
            return "updated";
        } else{
        Optional<ResourceDetails> op = resourceDetailsRepository.findById(rdid);
        if (op.isPresent()) {
            ResourceDetails rd = op.get();
            rd.setColumnValue(columnValue);
            resourceDetailsRepository.save(rd);
            return "updated!";
        } else return "failed!";
        }

    }
    @Override
    public List<Object> getAll(){
        try {
            List<Object> list = new ArrayList<>();
            for (ResourceDetails i : resourceDetailsRepository.findAll()) {
                ArrayList<Object> obj = new ArrayList<>();
                obj.add(i.getResource().getId());
                obj.add(i.getResource().getrCode());
                obj.add(i.getResource().getResourceName());
                obj.add(i.getColumnName());
                obj.add(i.getColumnValue());
                list.add(obj);
            }
            return list;
        }catch (Exception e){
            e.getStackTrace();
            return null;
        }
    }
}