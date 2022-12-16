package com.stegemoen.timetable.data;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ActivityID")
    private long activityID;
    @Column(name="text")
    private String text;
    @Column(name="start")
    private LocalDateTime start;
    @Column(name="end")
    private LocalDateTime end;

    public long getActivityID() {
        return activityID;
    }

    public void setActivityID(long activityID) {
        this.activityID = activityID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityID=" + activityID +
                ", text='" + text + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
