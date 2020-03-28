package com.itlize.korera.service.imp;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectToResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ProjectToResourceRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.service.ProjectToResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectToResourceServiceImp implements ProjectToResourceService {

    @Autowired
    private ProjectToResourceRepository projectToResourceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public boolean create(ProjectToResource projectToResource, Project project, Resource resource) {
        if(projectToResource==null || project==null || resource==null)
            return false;
        if(get(project,resource)!=null){
            System.out.println("project has added the resource");
            return false;
        }
        try{
            projectToResourceRepository.save(projectToResource);
            project.addProjectToResource(projectToResource);
            resource.addProjects(projectToResource);
            projectRepository.save(project);
            resourceRepository.save(resource);
        }catch (Exception e){
            System.out.println("Sth wrong happens when creating " + projectToResource.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ProjectToResource projectToResource) {
        try{
            projectToResourceRepository.delete(projectToResource);
        }catch (Exception e){
            System.out.println("Sth wrong happens when deleting " + projectToResource.toString());
            return false;
        }
        return true;
    }

    @Override
    public ProjectToResource get(Integer id) {
        Optional<ProjectToResource> target = projectToResourceRepository.findById(id);
        if(target.isPresent()){
            return target.get();
        }
        return null;
    }

    @Override
    public ProjectToResource get(Project project, Resource resource) {
        List<ProjectToResource> res = projectToResourceRepository.findByProjectAndResource(project,resource);
        if(res.size()>0){
            return res.get(0);
        }
        return null;
    }

    @Override
    public List<ProjectToResource> get(Project project) {
        return projectToResourceRepository.findByProject(project);
    }
}