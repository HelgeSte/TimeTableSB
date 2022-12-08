package com.stegemoen.timetable.model;
import java.io.*;
import java.util.Objects;

public class User implements Serializable {
    // ToDo: Refactor: rename User table and class to Employee, when adding Contacts.
    //private static int userIdCounter;
    //public int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    //public User(){
    //    userIdCounter++;
    //}

    public User(String firstName, String lastName, String email, String password) {
        //this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public String toString(){
        return this.firstName + ", " + this.lastName + ", " + this.email + ", " + this.password;
    }

    // Getters / setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, password);
    }
}
