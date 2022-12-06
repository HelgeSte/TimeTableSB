package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.User;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Users {
    public int saveToDB(User user) {
        int retval = -1;
       try (Connection conn = DbUtilities.getConnection();
       Statement stat = conn.createStatement()){
           String insertQuery = "INSERT INTO users(FirstName, LastName, Email, Password)" +
                   " VALUES ('" +
                   user.getFirstName() + "','" +
                   user.getLastName() + "','" +
                   user.getEmail() + "','" +
                   user.getPassword() + "');";
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

    public List<User> getUsers() throws SQLException, IOException{
        List<User> users = new ArrayList<>();
        try (Connection conn = DbUtilities.getConnection();
             Statement stat = conn.createStatement())
        {
            try (ResultSet result = stat.executeQuery("SELECT * FROM users");)
            {
                while (result.next()){
                    var s2 = result.getString(2);
                    var s3 = result.getString(3);
                    var s4 = result.getString(4);
                    var s5 = result.getString(5);
                    users.add(new User(
                            s2, s3, s4, s5
                    ));
                }
            }
        }
        return users;
    }

    List<User> findValue(String column, String value){
        List<User> users = new ArrayList<>();
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String query = "SELECT FirstName, LastName, Email, Password FROM Users WHERE "
                    + column + " LIKE '%" + value + "%';";
            try(ResultSet result = stat.executeQuery(query)){
                while(result.next()){
                    String s1 = result.getString(1);
                    String s2 = result.getString(2);
                    String s3 = result.getString(3);
                    String s4 = result.getString(4);
                    users.add(new User(s1, s2, s3, s4));
                }
            }
        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        return users;
    }

    Boolean findUserId(int value){
        List<User> users = new ArrayList<>();
        try(Connection conn = DbUtilities.getConnection();
            Statement stat = conn.createStatement()){
            String query = "SELECT FirstName, LastName, Email, Password FROM Users WHERE "
                    + "UserId = + value;";
            try(ResultSet result = stat.executeQuery(query)){
                while(result.next()){
                    String s1 = result.getString(1);
                    String s2 = result.getString(2);
                    String s3 = result.getString(3);
                    String s4 = result.getString(4);
                    users.add(new User(s1, s2, s3, s4));
                }
            }
        } catch(IOException|SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    boolean deleteUser(int id){
        try (Connection conn = DbUtilities.getConnection();
             Statement stat = conn.createStatement()){
             stat.executeUpdate("DELETE FROM users WHERE UserId=" + id);
            return true;

        } catch(SQLException|IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
