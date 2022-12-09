package com.stegemoen.timetable.model;
import java.io.*;
import java.util.Objects;

public class Employee extends Person {
    // ToDo: Refactor: rename User table and class to Employee, when adding Contacts.
    //private static int userIdCounter;
    //public int userId;
    private String password;
    private int employeeID; // Used when creating objects from sql queries

    //public User(){
    //    userIdCounter++;
    //}

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

    //public int getUserId() {
    //    return userId;
    //}

    //public void setUserId(int userId) {
    //    this.userId = userId;
    //}


}
