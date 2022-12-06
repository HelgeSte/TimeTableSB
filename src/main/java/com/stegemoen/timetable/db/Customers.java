package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Customers {
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

    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<>();
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            try (ResultSet result = stat.executeQuery("SELECT CompanyName FROM customers")){
                while(result.next()){
                    String s1 = result.getString(1);
                    customers.add(new Customer(s1));
                }
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return customers;
    }

    public String findValue(String column, String value){
        return null;
    }

    public boolean deleteCustomer(int id){
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
