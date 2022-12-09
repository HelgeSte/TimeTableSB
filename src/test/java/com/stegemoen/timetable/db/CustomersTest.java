package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Customer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomersTest {
    static List<Customers> customers = new ArrayList<>();
    static Customer apple = new Customer("Apple");
    static Customer cisco = new Customer("Cisco");
    static Customer nvidia = new Customer("Nvidia");
    static Customer kylotonn = new Customer("Kylotonn");
    static Customer tine = new Customer("Tine");
    static List<Integer> idList = new ArrayList<>();
    @BeforeAll
    public static void testAddUsers(){
        Customers c = new Customers();

        idList.add(c.saveToDB(apple));
        idList.add(c.saveToDB(cisco));
        idList.add(c.saveToDB(nvidia));
        idList.add(c.saveToDB(kylotonn));
        idList.add(c.saveToDB(tine));
    }

    @Test
    public void testGetCustomers() throws SQLException, IOException {
        List<Customer> customers = new Customers().getElementsFromDB();
        Customer customer = new Customer(
                "Apple");
        assertTrue(customers.contains(customer));
    }

    @AfterAll
    public static void deleteCustomers() {
        for(int i : idList ) {
            Customers customers = new Customers();
            customers.deleteElement(i);
        }
    }
}