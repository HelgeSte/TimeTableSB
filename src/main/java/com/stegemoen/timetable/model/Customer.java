/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stegemoen.timetable.model;
import java.io.*;
import java.util.Objects;

public class Customer implements Serializable {
    private String companyName;
    private int customerID = 0;


    public Customer( String companyName) {
        this.companyName = companyName;
    }
    public Customer( String companyName, int id) {
        this.companyName = companyName;
        this.customerID = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString(){
        return this.companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(companyName, customer.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName);
    }
}