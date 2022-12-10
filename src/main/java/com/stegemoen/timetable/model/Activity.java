package com.stegemoen.timetable.model;
import java.time.LocalDate;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Objects;

public class Activity implements Serializable {
    private String comment;
    private LocalDate date;
    private LocalDateTime start;
    private LocalDateTime end;
    /*public Project m_Project;
    public Employee m_Employee;*/


    /*public Activity(Project m_Project, Employee m_Employee) {
        this.m_Project = m_Project;
        this.m_Employee = m_Employee;
    }*/

    public Activity(String comment) {
        this.comment = comment;
    }
    public Activity(String comment, LocalDate date) {
        this.comment = comment;
        this.date = date;
    }


    public Activity(String comment,
                    LocalDate date,LocalDateTime start, LocalDateTime end) {
        this.comment = comment;
        /*this.m_Project = m_Project;
        this.m_Employee = m_Employee;*/
        this.date = date;
        this.end = end;
    }

    // getters / setters

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
