package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.User;
import com.itlize.Korera.repositories.ProjectRepository;
import com.itlize.Korera.repositories.UserRepository;
import com.itlize.Korera.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public String create(Integer id, String projectName, String uid){
        Optional<User> optional = userRepository.findById(uid);
        if (optional.isPresent()){
            User u= optional.get();
            Project p = new Project();
            p.setId(id);
            p.setOwner(u);
            p.setProjectName(projectName);
            projectRepository.save(p);
            return "Project{"+id+"} has been created successfully!";
        }else return "failed";
    }
    @Override
    public String deleteProjectById(Integer id){
        try{
            projectRepository.deleteById(id);
            return "Project{"+id+"} has been created successfully!";
        }catch (Exception e){
            e.getStackTrace();
            return "failed";
        }
    }
    @Override
    public String update(Integer pid, String projectName, String uid) {
        Optional<Project> optional = projectRepository.findById(pid);
        Optional<User> optionalUser = userRepository.findById(uid);
        if (optionalUser.isPresent() && optional.isPresent()) {
            User u = optionalUser.get();
            Project p = optional.get();
            p.setOwner(u);
            p.setProjectName(projectName);
            projectRepository.save(p);
            return "Project{" + pid + "} has been updated successfully!";
        } else return "failed!";
    }
    @Override
    public List<Project> readAll(){
        return projectRepository.findAll();
    }
    @Override
    public Optional<Project> readById(Integer id){
        return projectRepository.findById(id);
    }
}
