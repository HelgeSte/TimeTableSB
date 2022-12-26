package com.stegemoen.timetable.domain;

import javax.persistence.*;

@Entity
@Table(name="CONTACT")
public class Contact {
    @Id
    @GeneratedValue
    public Integer contactId;

    @Embedded
    private Person contactName;

    @Column
    private String contactEmail;

    @Column
    private String contactPhone;

    public Contact(Person contactName, String contactEmailx , String contactPhone) {
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    protected Contact() {
    }

    public Integer getContactId() {
        return contactId;
    }

    public Person getContactName() {
        return contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }
}