package com.stegemoen.timetable.data;

import javax.persistence.*;

@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="project_id")
    private long id;
    @Column(name="project_name")
    private String projectName;
    /*@Column(name="isActive")
    private int isActive;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /*public int isActive() {
        return isActive;
    }

    public void setActive(int active) {
        isActive = active;
    }*/

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
