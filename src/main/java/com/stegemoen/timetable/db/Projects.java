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
   List<Project> projects = new ArrayList<>();
   public int saveToDb(Project p){
       try(Connection conn = DbUtilities.getConnection();
           Statement stat = conn.createStatement()){
           String insertQuery = "INSERT INTO projects(ProjectName) VALUES('" + p.getProjectName() + "')";
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


}
