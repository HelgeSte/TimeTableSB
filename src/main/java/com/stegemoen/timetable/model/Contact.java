package com.stegemoen.timetable.model;

public class Contact extends Person {
    Customer company;
    String phone;
    int contactID = 0;

    public Contact(String firstName, String lastName, String email, String phone, Customer company){
        super(firstName, lastName, email);
        this.company = company;
        this.phone = phone;
    }

    public Contact(String firstName, String lastName, String email, String phone, Customer company, int ContactIdFromDB){
        super(firstName, lastName, email);
        this.company = company;
        this.phone = phone;
        this.contactID = ContactIdFromDB;
    }

    public String getFullName(){
        return super.getFirstName()  + " " + super.getLastName();
    }

    public Customer getCompany() {
        return company;
    }

    public void setCompany(Customer company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getContactID() {
        return contactID;
    }
}
