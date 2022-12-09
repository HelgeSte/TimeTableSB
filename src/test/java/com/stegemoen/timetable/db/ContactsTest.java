package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Contact;
import com.stegemoen.timetable.model.Customer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ContactsTest {
    @Test
    public void testSaveToDB(){
        Customer mi5 = new Customer("MI5");
        int customerId = (new Customers()).saveToDB(mi5);
        Contact bond = new Contact(
                "James", "Bond", "fake@fakecontact.com", "007", mi5);
        int contactID = (new Contacts()).saveToDB(bond, customerId);
        assertTrue(contactID > 0);
    }

    @Test
    public void testGetContactList() throws SQLException, IOException {
        Customer ms = new Customer("Microsoft");
        int customerId = (new Customers()).saveToDB(ms);
        Contact bond = new Contact(
                "Bill", "Gates", "fake@fakecontact.com", "555-99743", ms);
        int contactID = (new Contacts()).saveToDB(bond, customerId);
        List<Contact> contactList = new ArrayList<>();
        contactList = (new Contacts()).getElementsFromDB();
        assertTrue(contactList.size() > 0);
    }

    @Test
    public void testDeleteContact() throws SQLException, IOException{
        var clist = (new Contacts()).getElementsFromDB().stream()
                .filter(x -> x.getEmail().equals("fake@fakecontact.com"))
                .collect(Collectors.toList());
        clist.stream().forEach(e -> (new Contacts()).deleteElement(e.getContactID()));
        var simpsonCount = (new Contacts()).getElementsFromDB().stream()
                .filter(x -> x.getEmail().equals("fake@fakecontact.com"))
                .collect(Collectors.toList()).size();
        assertEquals(0, simpsonCount);
    }

}