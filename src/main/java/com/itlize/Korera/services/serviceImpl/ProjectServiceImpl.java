package com.itlize.Korera.services.serviceImpl;

import com.itlize.Korera.dbModels.Project;
import com.itlize.Korera.dbModels.User;
import com.itlize.Korera.repositories.ProjectRepository;
import com.itlize.Korera.repositories.UserRepository;
import com.itlize.Korera.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean create(Project project, User user) {
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
            System.out.println("Sth wrong happens when creating");
            return false;
        }
        return  true;
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
    public Project get(Integer id) {
        Optional<Project> res = projectRepository.findById(id);
        if(res.isPresent()){
            return res.get();
        }
        return null;
    }
}
