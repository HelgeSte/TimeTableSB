package com.stegemoen.timetable.db;
import com.stegemoen.timetable.model.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest {
    static List<Integer> userId = new ArrayList<>();
    static Employee homer = new Employee(
            "Homer",
            "Simpson",
            "fake@fakeemail12345.com",
            "TopSecretNoHumbug"
    );
    static Employee marge = new Employee(
            "Marge",
            "Simpson",
            "fake@fakeemail12345.com",
            "HomerJay_01"
    );
    static Employee peter = new Employee(
            "Peter",
            "Griffin",
            "fake@fakeemail12345.com",
            "BirdsTheWord"
    );
    static Employee donald = new Employee(
            "Donald",
            "Duck",
            "fake@fakeemail12345.com",
            "Daisy<3"
    );
    static Employee daisy = new Employee(
            "Daisy",
            "Duck",
            "fake@fakeemail12345.com",
            "Donald313"
    );
    @BeforeAll
    public static void addTestUsers(){
        Employees u = new Employees();
        userId.add(u.saveToDB(homer));
        userId.add(u.saveToDB(marge));
        userId.add(u.saveToDB(peter));
        userId.add(u.saveToDB(donald));
        userId.add(u.saveToDB(daisy));

    }

    @Test
    public void testAddUsers(){
        assertTrue( userId.get(0) >= 0
                && userId.get(1) >= 0
                && userId.get(2) >= 0
                && userId.get(3) >= 0
                && userId.get(4) >= 0);
    }

    @Test
    public void testGetUsers() throws SQLException, IOException {
        List<Employee> employees = new Employees().getElementsFromDB();
        Employee marge = new Employee(
                "Marge",
                "Simpson",
                "fake@fakeemail12345.com",
                "HomerJay_01"
        );
        assertTrue(employees.contains(marge));
    }

    @Test
    public void findUserByEmail(){
        List<Employee> employees = new Employees().findValue("Email", "fakeemail12345.com");
        assertTrue(employees.size() > 0);
    }

    @Test
    public void findUsersByFirstname(){
        List<Employee> employees = new Employees().findValue("FirstName", "Daisy");
        assertTrue(employees.size() > 0);

    }

    @Test
    public void findUsersByLastName(){
        List<Employee> employees = new Employees().findValue("LastName", "simp");
        assertTrue(employees.size() > 0);
    }

    @Test
    public void deleteTestUser() throws IOException, SQLException{
        var elist = (new Employees()).getElementsFromDB().stream()
                .filter(x -> x.getEmail().equals("fake@fakeemail12345.com"))
                .collect(Collectors.toList());
        elist.stream().forEach(e -> (new Employees()).deleteElement(e.getEmployeeID()));
        var simpsonCount = (new Employees()).getElementsFromDB().stream()
                .filter(x -> x.getEmail().equals("fake@fakeemail12345.com"))
                .collect(Collectors.toList()).size();
        assertEquals(0, simpsonCount);
    }

    @AfterAll
    public static void deleteTestUsers() throws IOException, SQLException{
        Employees u = new Employees();
        u.deleteElement(userId.get(1));
        u.deleteElement(userId.get(2));
        u.deleteElement(userId.get(3));
        u.deleteElement(userId.get(4));
    }
}