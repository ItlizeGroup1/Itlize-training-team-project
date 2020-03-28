package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Columns;
import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.repositories.ColumnsRepository;
import com.itlize.Korera.repositories.ProjectRepository;
import com.itlize.Korera.services.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColumnsServiceImpl implements ColumnsService {

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
