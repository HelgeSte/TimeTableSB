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

    @ManyToOne
    @JoinColumn
    private Company company;

    public Project(String projectName, Employee employee, Company company) {
        this.projectName = projectName;
        this.employee = employee;
        this.company = company;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
