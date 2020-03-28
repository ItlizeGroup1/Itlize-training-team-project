package com.itlize.korera.service.imp;

import com.itlize.korera.entity.Columns;
import com.itlize.korera.entity.Project;
import com.itlize.korera.repository.ColumnsRepository;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ColumnsServiceImp implements ColumnsService {

    @Autowired
    private ColumnsRepository columnsRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean create(Columns column) {
        Columns target = get(column.getProject(),column.getColumnName());
        if(target != null){
            System.out.println("Column exist!");
            return false;
        }
        try{
            columnsRepository.save(column);
        }catch (Exception e){
            System.out.println("Sth wrong happens when creating "+column.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean create(Columns column, Project project) {
        Columns target = get(project,column.getColumnName());
        if(target != null){
            System.out.println("Column exist!");
            return false;
        }
        try{
            columnsRepository.save(column);
            project.addColumns(column);
            columnsRepository.save(column);
            projectRepository.save(project);
        }catch (Exception e){
            System.out.println("Sth wrong happens when creating "+column.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Columns column) {
        try{
            columnsRepository.delete(column);
        }catch (Exception e){
            System.out.println("Sth wrong happens when deleting "+column.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Columns column, String newColumnName) {
        Columns toUpdate = get(column.getId());
        if(toUpdate==null){
            System.out.println("target column not found!");
            return false;
        }
        column.setColumnName(newColumnName);
        try{
            columnsRepository.save(column);
        }catch (Exception e){
            System.out.println("Sth wrong happens when updating");
            return false;
        }
        return true;
    }

    @Override
    public Columns get(Integer id) {
        if(id ==null)
            return null;
        Optional<Columns> res = columnsRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        return null;
    }

    @Override
    public Columns get(Project project, String columnName) {
        List<Columns> res = columnsRepository.findByProjectAndColumnName(project,columnName);
        if(res.size()>0){
            return res.get(0);
        }
        return null;
    }
}