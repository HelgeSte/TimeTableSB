package com.stegemoen.timetable.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
class ActivityTest {
    @Test
    void createObjects(){
        Activity a = new Activity(
                "Test activity 1",
                LocalDate.of(1994, 10, 30),
                LocalDateTime.of(LocalDate.now(),
                        LocalTime.of(11,30)));
        a.setEndTime(LocalDateTime.of(
                LocalDate.now(),
                LocalTime.of(13, 45)));
        a.setFinished(true);

        assertEquals(135, a.getActiveMinutes());
    }

    @Test
    void testActivityHours(){
        Activity a = new Activity(
                "Test activity 1",
                LocalDate.of(1994, 10, 30),
                LocalDateTime.of(LocalDate.of(2022,12,10),
                        LocalTime.of(22,00)));
        a.setEndTime(LocalDateTime.of(
                LocalDate.of(2022,12,11),
                LocalTime.of(5, 45)));
        a.setFinished(true);
        var hours = a.getActiveHours();
        System.out.printf("Hours = %.2f", hours);
        assertEquals("7,75", String.format("%.2f",hours)); //
    }

    @Test
    void setStart() {
        Activity act = new Activity("Design Windows 12");
        LocalDate temp = LocalDate.of(1971,5,19);
        act.setCreatedDate(temp);
        LocalDate date = act.getCreatedDate();
        System.out.println(date);
        // Using two different assertEquals to have both as reference for later
        assertEquals(LocalDate.of(1971,05,19), date);
        assertEquals("1971-05-19", date.toString());
    }

    @Test
    void getComment() {
    }

    @Test
    void setComment() {
    }

    @Test
    void getHours() {
    }

    @Test
    void setHours() {
    }

    @Test
    void getStart() {
    }

    @Test
    void testSetStart() {
    }

    @Test
    void setTimer() {
    }
}