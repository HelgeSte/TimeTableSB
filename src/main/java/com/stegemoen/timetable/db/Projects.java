package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.model.Project;
import com.stegemoen.timetable.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Projects {
    // ToDo: Create a contact class and add field for ContactID in db & Projects class.
   List<Project> projects = new ArrayList<>();
   public int saveToDb(Project p){
       // Add User to Users db and get UserID:
       int userId = (new Users()).saveToDB(p.getProjectManager());
       // Add Customer to Customers db and get CustomerID:
       int customerId = (new Customers()).saveToDB(p.getCustomer());
       try(Connection conn = DbUtilities.getConnection();


           Statement stat = conn.createStatement()){
           String insertQuery =
                   String.format("INSERT INTO projects(ProjectName,isActive, UserID, CustomerID) VALUES('%s', %b, %d, %d);",
                           p.getProjectName(), p.isActive(), userId, customerId);
           stat.executeUpdate(insertQuery);
           try(ResultSet returnValue = stat.executeQuery("@@IDENTITY")){
                if(returnValue.next())
                    return returnValue.getInt(1);
           }
       }catch(IOException|SQLException e) {
           System.out.println(e.getMessage());
       }
       return -1;
   }
    public boolean disableProject(int id){
        try(Connection conn = DbUtilities.getConnection();
            Statement stat = conn.createStatement()){
            stat.executeUpdate("DELETE FROM customers WHERE CustomerId=" + id);
            return true;

        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Project> getProjects(){ // ToDo: Add getUser(int id), getCustomer(int id)
        List<Project> projects = new ArrayList<>();
       /* try(Connection conn = DbUtilities.getConnection();
            Statement stat = conn.createStatement()){
            try (ResultSet result = stat.executeQuery("SELECT ProjectName, UserID, CustomerID FROM customers")){
                while(result.next()){
                    String s1 = result.getString(1);

                    projects.add(new Project(s1));
                }
            }

        } catch(Exception e){
            System.out.println(e.getMessage());
        }*/
        return projects;
    }
    public boolean deleteProject(int id){
        try(Connection conn = DbUtilities.getConnection();
            Statement stat = conn.createStatement()){
            stat.executeUpdate("DELETE FROM Projects WHERE ProjectID =" + id);
            return true;

        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
