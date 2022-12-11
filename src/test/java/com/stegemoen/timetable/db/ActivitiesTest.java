package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Activity;
import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.model.Employee;
import com.stegemoen.timetable.model.Project;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActivitiesTest {
    static Activity aTest;

    @BeforeAll
    static void beforeAll(){
        aTest = new Activity(
                "Test activity",
                LocalDate.of(1994, 10, 30),
                LocalDateTime.of(LocalDate.now(),
                        LocalTime.of(10,00)));
        aTest.setEndTime(LocalDateTime.of(
                LocalDate.now(),
                LocalTime.of(12, 45)));
        aTest.setFinished(true);
    }
    /*
     */
    @Test
    void createObjects(){
        Activity a = new Activity(
                "Test activity 2",
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
                "Test activity 3",
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
        Activity act = new Activity("Test Activity 4");
        LocalDate temp = LocalDate.of(1971,5,19);
        act.setCreatedDate(temp);
        LocalDate date = act.getCreatedDate();
        System.out.println(date);
        // Using two different assertEquals to have both as reference for later
        assertEquals(LocalDate.of(1971,05,19), date);
        assertEquals("1971-05-19", date.toString());
    }

    @Test
    void addToDB(){
        Customer c = new Customer("Polly");
        int cid = (new Customers()).saveToDB(c);
        Project p = new Project("Fest med Jothepus og MacIvar", c);
        Employee e = new Employee("Hercules", "Poirot", "hercules@teaparty.co.uk", "AC123");
        int eid = (new Employees()).saveToDB(e);
        int pid = (new Projects()).saveToDB(p, cid, eid);
        int id = (new Activities()).saveToDB(aTest, pid, eid);
        assertTrue(id > 0);
    }


}