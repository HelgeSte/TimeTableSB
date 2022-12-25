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

    @Column
    private String contactName;

    @OneToMany(mappedBy="company",
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private List<Project> projectList = new ArrayList<>();

    public Company(String companyName, String contactName) {
        this.companyName = companyName;
        this.contactName = contactName;
    }

    protected Company() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }


    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
