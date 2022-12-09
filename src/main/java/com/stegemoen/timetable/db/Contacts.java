package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Contact;
import com.stegemoen.timetable.model.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Contacts implements iTimeTableDB<Contact> {
    List<Contact> contacts = new ArrayList<>();
    public int saveToDB(Contact c, int companyID){
        try(Connection conn = DbUtilities.getConnection();


            Statement stat = conn.createStatement()){
            String insertQuery =
                    String.format(
                            "INSERT INTO Contacts(FirstName,LastName, Email, Phone, CustomerID) "+
                                    "VALUES('%s', '%s', '%s', '%s', %d);",
                            c.getFirstName(), c.getLastName(), c.getEmail(), c.getPhone(), companyID);
            stat.executeUpdate(insertQuery);
            try(ResultSet returnValue = stat.executeQuery("SELECT @@IDENTITY")){
                if(returnValue.next())
                    return returnValue.getInt(1);
            }
        }catch(IOException|SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
    @Override
    public Contact getElement(int t_id) {
        return null;
    }

    @Override
    public List<Contact> getElementsFromDB() throws SQLException, IOException {
        List<Contact> contactList = new ArrayList<>();
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String query = String.format(
                    "SELECT FirstName,LastName,Email,Phone,CustomerID,ContactID FROM Contacts");
                    try(ResultSet results = stat.executeQuery(query)){
                        while(results.next()){
                            contactList.add(
                                    new Contact(
                                            results.getString(1),
                                            results.getString(2),
                                            results.getString(3),
                                            results.getString(4),
                                            (new Customers()).getElement(results.getInt(5)),
                                            results.getInt(6)   // Getting the id makes deleting and updating easier
                                    )
                            );
                        }
                    }

        }catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        return contactList;
    }

    @Override
    public boolean deleteElement(int cid) {
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String updateQuery = String.format(
                    "DELETE FROM Contacts WHERE ContactID=%d;",cid);
            stat.executeUpdate(updateQuery);

        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    // ToDo: Continue finding method for the iTimeTable interface, and then code this class
}
