package com.stegemoen.timetable.model;
import java.util.Calendar;
import java.io.*;
import java.util.Objects;

/**
 *
 * @author hsteg
 */
public class Project {
    String projectName;
    Customer customer;
    User projectManager;
    int CustomerID = -1; // -1 = error condition, because all projects should have a customer
    int UserID = 0;     // 0 = not an error, because a project manager might be assigned later

    public Project(String projectName, Customer customer, User projectManager) {
        this.projectName = projectName;
        this.customer = customer;
        this.projectManager = projectManager;
    }

    // Not used yet, but it should be possible to crate a project without a project manager
    public Project(String projectName, Customer customer) {
        this.projectName = projectName;
        this.customer = customer;
        this.projectManager = projectManager;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    public int getCustomerID() {
        return CustomerID;
    }
    public int getCustomerID(Customer customer) {
        return CustomerID;
    }

    public int getUserID() {
        return UserID;
    }

    public int getUserID(User user){
        // ToDo: code for finding a user in the database and return the userID
        return -1;
    }

    // It should be possible to change the project manager
    public void setUserID(int userID) {
        UserID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectName, project.projectName) && Objects.equals(customer, project.customer) && Objects.equals(projectManager, project.projectManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, customer, projectManager);
    }
}
