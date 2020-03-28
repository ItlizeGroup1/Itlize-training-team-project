package com.itlize.korera.service.imp;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.User2;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.UserRepository1;
import com.itlize.korera.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImp implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository1 userRepository;

    @Override
    public String create(Integer id, String projectName, String uid){
        Optional<User2> optional = userRepository.findById(uid);
        if (optional.isPresent()){
            User2 u= optional.get();
            Project p = new Project();
            p.setId(id);
            p.setOwner(u);
            p.setProjectName(projectName);
            projectRepository.save(p);
            return "Project{"+id+"} has been created successfully!";
        }else return "failed";
    }

    @Override
    public boolean create(Project project, User2 user) {
        Project target = get(project.getId());
        if(target!=null){
            System.out.println("project already exists");
            return false;
        }
        try{
            projectRepository.save(project);
            user.addProjects(project);
            projectRepository.save(project);
            userRepository.save(user);
        }catch (Exception e){
            System.out.println("Sth wrong happens when creating: " + e.getMessage());
            return false;
        }
        return  true;
    }

    @Override
    public boolean deleteProjectById(Integer id){
        try{
            projectRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Project project) {
        try{
            projectRepository.delete(project);
        }catch (Exception e){
            System.out.println("Sth wrong happens when deleting");
            return false;
        }
        return  true;
    }

    @Override
    public String update(Integer pid, String projectName, String uid) {
        Optional<Project> optional = projectRepository.findById(pid);
        Optional<User2> optionalUser = userRepository.findById(uid);
        if (optionalUser.isPresent() && optional.isPresent()) {
            User2 u = optionalUser.get();
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

    @Override
    public Project get(Integer id) {
        if(id==null)
            return null;
        Optional<Project> res = projectRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        return null;
    }
}