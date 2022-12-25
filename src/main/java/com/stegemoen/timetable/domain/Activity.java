package com.stegemoen.timetable.domain;

import javax.persistence.*;

@Entity
@Table(name="ACTIVITY")
public class Activity {
    @Id
    @GeneratedValue
    private Integer activityId;

    @Column
    private String comment;

    /*@ManyToOne
    private Employee employee; // The worker, not the project manager, which is defined in project

    @ManyToOne
    private Project project;*/
}
