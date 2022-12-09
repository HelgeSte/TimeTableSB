package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Customers implements iTimeTableDB<Customer>, iSave<Customer> {
    public int saveToDB(Customer customer){
        int retval = -1;
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String insertQuery = "INSERT INTO " +
                    "customers(CompanyName)" +
                    " VALUES ('" +
                    customer.getCompanyName() + "');";
            stat.executeUpdate(insertQuery);
            try(ResultSet returnValue = stat.executeQuery("SELECT @@IDENTITY")){
                if(returnValue.next())
                    return returnValue.getInt(1);
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
        return -1;
    }

    public List<Customer> getElementsFromDB(){
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            try (ResultSet result = stat.executeQuery("SELECT CompanyName,CustomerID FROM customers")){
                while(result.next()){
                    String s1 = result.getString(1);
                    int id = result.getInt(2);
                    customers.add(new Customer(s1, id));
                }
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return customers;
    }

    public Customer getElement(int id){
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String query = String.format(
                    "SELECT CompanyName FROM Customers WHERE CustomerID=%d;",
                    id);
            try(ResultSet result = stat.executeQuery(query)){
                return new Customer("CompanyName");
            }
        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean deleteElement(int id){
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            stat.executeUpdate("DELETE FROM customers WHERE CustomerId=" + id);
            return true;

        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
