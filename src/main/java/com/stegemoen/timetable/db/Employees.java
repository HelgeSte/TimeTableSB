package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Employee;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// ToDo: Add LocalDate birthday
public class Employees implements iTimeTableDB<Employee>, iSave<Employee> {
    public int saveToDB(Employee employee) {
        int retval = -1;
       try (Connection conn = DbUtilities.getConnection();
       Statement stat = conn.createStatement()){
           String insertQuery = "INSERT INTO Employees(FirstName, LastName, Email, Password)" +
                   " VALUES ('" +
                   employee.getFirstName() + "','" +
                   employee.getLastName() + "','" +
                   employee.getEmail() + "','" +
                   employee.getPassword() + "');";
           stat.executeUpdate(insertQuery);
           try(ResultSet returnValue = stat.executeQuery("SELECT @@IDENTITY")){
               if(returnValue.next())
                   return returnValue.getInt(1);
           }
        } catch(Exception se){
            System.out.println(se.getMessage());
            return -1;
        }

        return -1;
    }

    public List<Employee> getElementsFromDB() throws SQLException, IOException{
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = DbUtilities.getConnection();
             Statement stat = conn.createStatement())
        {
            try (ResultSet result = stat.executeQuery(
                    "SELECT FirstName,LastName,Email,EmployeeID FROM Employees");)
            {
                while (result.next()){
                    String s1 = result.getString(1);
                    String s2 = result.getString(2);
                    String s3 = result.getString(3);
                    int id = result.getInt(4);
                    employees.add(new Employee(
                            s1, s2, s3, id
                    ));
                }
            }
        }
        return employees;
    }

    List<Employee> findValue(String column, String value){
        List<Employee> employees = new ArrayList<>();
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String query = "SELECT FirstName, LastName, Email, Password FROM Employees WHERE "
                    + column + " LIKE '%" + value + "%';";
            try(ResultSet result = stat.executeQuery(query)){
                while(result.next()){
                    String s1 = result.getString(1);
                    String s2 = result.getString(2);
                    String s3 = result.getString(3);
                    String s4 = result.getString(4);
                    employees.add(new Employee(s1, s2, s3, s4));
                }
            }
        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        return employees;
    }

    public Employee getElement(int id){
        try(Connection conn = DbUtilities.getConnection();
            Statement stat = conn.createStatement()){
            String query = String.format(
                    "SELECT FirstName, LastName, Email, Password FROM Employees WHERE EmployeeID=%d;",
                    id);
            try(ResultSet result = stat.executeQuery(query)){
                if(result.next()){
                    String s1 = result.getString(1);
                    String s2 = result.getString(2);
                    String s3 = result.getString(3);
                    String s4 = result.getString(4);
                    return new Employee(s1, s2, s3, s4);
                }
            }
        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    public boolean deleteElement(int id){
        try (Connection conn = DbUtilities.getConnection();
             Statement stat = conn.createStatement()){
             stat.executeUpdate("DELETE FROM Employees WHERE EmployeeID=" + id);
            return true;

        } catch(SQLException|IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
