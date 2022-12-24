package com.stegemoen.timetable.domain;

import javax.persistence.*;

@Entity
@Table(name="CONTACT")
public class Contact {
    @Id
    @GeneratedValue
    public Integer contactId;

    @Embedded
    private Person person;

    @Column
    private String email;

    @Column
    private String phone;

    @ManyToOne
    @JoinColumn
    private Company company;

    public Contact(Person person, String email, String phone, Company company) {
        this.person = person;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

    protected Contact() {
    }

    public Integer getContactId() {
        return contactId;
    }

    public Person getPerson() {
        return person;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setCompany(Company company){
        this.company = company;
    }
}