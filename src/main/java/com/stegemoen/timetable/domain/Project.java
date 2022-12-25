package com.stegemoen.timetable.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ACTIVITY")
public class Project {
    @Id
    @GeneratedValue
    private Integer projectId;

    @Column
    private String projectName;

    @Column
    private boolean active;

    @ManyToOne
    @JoinColumn
    private Company company;


    public Project(String projectName, boolean active,Company company) {
        this.company = company;
        this.projectName = projectName;
        this.active = active;
    }

    protected Project() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setActivityList(){

    }
}
