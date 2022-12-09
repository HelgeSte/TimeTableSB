package com.stegemoen.timetable.db;
import com.stegemoen.timetable.model.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeesTest {
    static List<Integer> userId = new ArrayList<>();
    static Employee homer = new Employee(
            "Homer",
            "Simpson",
            "homer.simpson@moes.com",
            "TopSecretNoHumbug"
    );
    static Employee marge = new Employee(
            "Marge",
            "Simpson",
            "marge.simpson@springfield.com",
            "HomerJay_01"
    );
    static Employee peter = new Employee(
            "Peter",
            "Griffin",
            "peter.griffin@thebird.com",
            "BirdsTheWord"
    );
    static Employee donald = new Employee(
            "Donald",
            "Duck",
            "donald.duck@theangryduck.com",
            "Daisy<3"
    );
    static Employee daisy = new Employee(
            "Daisy",
            "Duck",
            "daisy@duckies.com",
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
                "marge.simpson@springfield.com",
                "HomerJay_01"
        );
        assertTrue(employees.contains(marge));
    }

    @Test
    public void findUserByEmail(){
        List<Employee> employees = new Employees().findValue("Email", "springfield");
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
        Employees u = new Employees();
        int rmId = userId.get(0);
        u.deleteElement(rmId);
        //assertFalse(new Users().getObject(rmId));
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