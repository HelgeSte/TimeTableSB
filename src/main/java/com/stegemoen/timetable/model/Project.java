package com.stegemoen.timetable.model;
import java.util.Objects;

/**
 *
 * @author hsteg
 */
public class Project {
    String projectName;
    Boolean active;
    Customer customer;
    Employee projectManager;
    int projectID = 0;
    int CustomerID = -1; // -1 = error condition, because all projects should have a customer
    int EmployeeID = 0;     // 0 = not an error, because a project manager might be assigned later

    public Project(String projectName, Customer customer, Employee projectManager) {
        this.projectName = projectName;
        this.customer = customer;
        this.projectManager = projectManager;
    }

    public Project(String projectName, Customer customer, Employee projectManager, int projectID) {
        this.projectName = projectName;
        this.customer = customer;
        this.projectManager = projectManager;
        this.projectID = projectID;
    }

    // Not used yet, but it should be possible to crate a project without a project manager
    public Project(String projectName, Customer customer) {
        this.projectName = projectName;
        this.customer = customer;
        this.projectManager = projectManager;
        this.active = true;
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

    public Employee getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public int getCustomerID() {
        return CustomerID;
    }
    public int getCustomerID(Customer customer) {
        return CustomerID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public int getEmployeeID(Employee employee){
        return -1;
    }

    // It should be possible to change the project manager
    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public Boolean getActive() {
        return active;
    }

    public int getProjectID() {
        return projectID;
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
