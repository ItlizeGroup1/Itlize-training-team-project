package com.itlize.korera.service;

import java.util.List;


public interface ProjectResourceService {
    List<Integer> getProjectResourceByPid(Integer id);
    String deleteProjectResource(Integer id);
    String addProjectResource(Integer Pid,Integer Rid);

}
