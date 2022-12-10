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
        a.setEnd(LocalDateTime.of(
                LocalDate.now(),
                LocalTime.of(13, 33)));

        /*String startDate = a.getDate().toString();
        String strStart = a.getStart().toString();
        String strEnd = a.getEnd().toString();
        System.out.println(startDate);
        System.out.println(strStart);
        System.out.println(strEnd);
        System.out.println(a.getUsedTime());*/


        // Different variation of LocalDate, LocalTime and LocalDateTime
        LocalTime locTime = LocalTime.of(19, 30);
        LocalTime secTime = LocalTime.of(19,30,41);
        LocalDate locDate = LocalDate.of(2022, 12, 10);
        LocalDateTime locDateTime = LocalDateTime.of(locDate, locTime);
        LocalDateTime birthDay = LocalDateTime.of(
                LocalDate.of(1971,5,19),
                LocalTime.of(11,30)
        );

        a.setEnd(LocalDateTime.now());
    }

    @Test
    void setStart() {
        Activity act = new Activity("Design Windows 12");
        LocalDate temp = LocalDate.of(1971,5,19);
        act.setDate(temp);
        LocalDate date = act.getDate();
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