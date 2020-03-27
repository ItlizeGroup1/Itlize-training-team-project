package com.itlize.korera.service;



import com.itlize.korera.entity.ProjectUser;

import java.util.List;

public interface ProjectUserService {

    List<ProjectUser> getProjectByUserId(Integer Uid);
}
