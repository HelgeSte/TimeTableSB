package com.stegemoen.timetable.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

// ToDo: Embedded class (aka Spring Data 2 - attendee)
@Embeddable
public class Person {
    @Column
    private String firstName;

    @Column
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
