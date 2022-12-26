package com.stegemoen.timetable.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Company")
public class Company {
    @Id
    @GeneratedValue
    private Integer companyId;

    @Column
    private String companyName;

    @OneToMany(mappedBy="company", // company from ManyToOne mapping in Contact
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Project> projects = new ArrayList<>();

    public Company(String companyName) {
        this.companyName = companyName;
    }
    public Company(Integer companyId, String companyName) {
        this.companyId = companyId;
        this.companyName = companyName;
    }

    protected Company() {
    }

    public Integer getCompanyId() {
        return companyId;
    }
    public void setCompanyId(Integer companyId){
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addProject(Project project){
        projects.add(project);
    }


    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
