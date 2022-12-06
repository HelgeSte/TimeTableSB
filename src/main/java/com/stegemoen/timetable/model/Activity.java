package com.stegemoen.timetable.model;
import java.time.LocalDate;
import java.util.Calendar;
import java.io.*;
import java.util.Objects;

public class Activity implements Serializable {
    private String comment;
    private LocalDate start;
    private double hours;    // hours used
    public Project m_Project;
    public User m_User;


    public Activity(Project m_Project, User m_User) {
        this.m_Project = m_Project;
        this.m_User = m_User;
    }
    
    public Activity(String comment, Project m_Project, User m_User, 
            LocalDate start, double hours) {
        this.comment = comment;
        this.m_Project = m_Project;
        this.m_User = m_User;
        this.start = start;
        this.hours = hours;
    }
    
    @Override
    public String toString(){
        return m_Project.getProjectName() + "\t" + m_User.getFirstName() + " "
                + m_User.getLastName() + "\t" + this.comment;
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

    public User getM_User() {
        return m_User;
    }

    public void setM_User(User m_User) {
        this.m_User = m_User;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Double.compare(activity.hours, hours) == 0 && Objects.equals(start, activity.start) && Objects.equals(m_Project, activity.m_Project) && Objects.equals(m_User, activity.m_User);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, hours, m_Project, m_User);
    }
}
