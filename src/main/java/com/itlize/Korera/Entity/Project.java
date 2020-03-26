package com.itlize.Korera.Entity;


import java.util.List;

/**
 *
 */
public class Project {
    private Integer id;

    private List<Resource> resourceList;

    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
