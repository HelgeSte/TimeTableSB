package com.stegemoen.timetable.model;

public class Employee extends Person {
    // ToDo: Refactor: rename User table and class to Employee, when adding Contacts.
    private String password;
    private int employeeID; // Used when creating objects from sql queries

    public Employee(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email);
        this.password = password;
    }

    public Employee(
            String firstName, String lastName, String email, int employeeID) {
        super(firstName, lastName, email);
        this.employeeID = employeeID;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}
