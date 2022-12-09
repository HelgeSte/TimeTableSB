package com.stegemoen.timetable.model;
import java.time.LocalDate;
import java.io.*;
import java.util.Objects;

public class Activity implements Serializable {
    private String comment;
    private LocalDate start;
    private double hours;    // hours used
    public Project m_Project;
    public Employee m_Employee;


    public Activity(Project m_Project, Employee m_Employee) {
        this.m_Project = m_Project;
        this.m_Employee = m_Employee;
    }
    
    public Activity(String comment, Project m_Project, Employee m_Employee,
            LocalDate start, double hours) {
        this.comment = comment;
        this.m_Project = m_Project;
        this.m_Employee = m_Employee;
        this.start = start;
        this.hours = hours;
    }
    
    @Override
    public String toString(){
        return m_Project.getProjectName() + "\t" + m_Employee.getFirstName() + " "
                + m_Employee.getLastName() + "\t" + this.comment;
    }

    // getters / setters

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setTimer(double timer) {
        this.hours = timer;
    }

    public Project getM_Prosjekt() {
        return m_Project;
    }

    public void setM_Prosjekt(Project m_Prosjekt) {
        this.m_Project = m_Prosjekt;
    }

    public Employee getM_User() {
        return m_Employee;
    }

    public void setM_User(Employee m_Employee) {
        this.m_Employee = m_Employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Double.compare(activity.hours, hours) == 0 && Objects.equals(start, activity.start) && Objects.equals(m_Project, activity.m_Project) && Objects.equals(m_Employee, activity.m_Employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, hours, m_Project, m_Employee);
    }
}
