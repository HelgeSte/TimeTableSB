package com.stegemoen.timetable.domain;

import javax.persistence.*;

@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue
    private Integer projectId;

    @Column
    private String projectName;

    @ManyToOne
    @JoinColumn
    private Employee employee;

    public Project(String projectName, Employee employee) {
        this.projectName = projectName;
        this.employee = employee;
    }

    protected Project(){}

    public Integer getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public Employee getEmployee() {
        return employee;
    }
}
