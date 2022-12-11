package com.stegemoen.timetable.model;
import java.time.LocalDate;
import java.io.*;
import java.time.LocalDateTime;

public class Activity implements Serializable {
    private String comment;
    private LocalDate createdDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean finished;
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
        this.createdDate = date;
    }


    public Activity(String comment,
                    LocalDate date,LocalDateTime start) {
        this.comment = comment;
        /*this.m_Project = m_Project;
        this.m_Employee = m_Employee;*/
        this.createdDate = date;
        this.startTime = start;
    }

    // getters / setters

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getActiveMinutes(){
        var minutes =  this.endTime.getMinute() - this.startTime.getMinute();
        int hours = this.endTime.getHour() - this.startTime.getHour();
        return minutes + hours * 60;
    }
    public double getActiveHours(){
        //double years = endTime.getYear() - startTime.getYear();
        double days = endTime.getDayOfYear() - startTime.getDayOfYear();
        double hours;

        if(days == 1){
            hours = 24 - startTime.getHour() + endTime.getHour();
        } else if(days > 1){
            throw new IllegalArgumentException("Not allowed to work for more than one day!");
        }
        else {
            hours = endTime.getHour() - startTime.getHour();
        }

        double minutes = endTime.getMinute() - startTime.getMinute();

        double minTing = minutes / 60;
        return hours + minutes / 60;

    }
}
