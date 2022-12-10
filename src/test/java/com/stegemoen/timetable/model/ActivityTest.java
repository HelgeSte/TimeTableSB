package com.stegemoen.timetable.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class ActivityTest {
    @Test
    void createObjects(){
        Activity a = new Activity(
                "Test activity 1",
                LocalDate.of(1994, 10, 30)
        );
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