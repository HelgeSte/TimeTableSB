package com.stegemoen.timetable.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Company")
public class Company {
    @Id
    @GeneratedValue
    private Integer companyId;

    @Column
    private String companyName;

    @OneToMany(mappedBy="company", // company from ManyToOne mapping in Contact
    fetch = FetchType.EAGER,
    cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();



    public Company(String companyName) {
        this.companyName = companyName;
    }

    protected Company() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
