package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Activity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Activities implements iTimeTableDB<Activity> {
    public int saveToDB(Activity activity) {
        List<Activity> activities = new ArrayList<>();
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String inputQuery = String.format(
                    "INSERT INTO activities() VALUES ('%s', %s, %s);",
                    activity.getComment(),
                    activity.getStartTime(),
                    activity.getEndTime()
            );
            try(ResultSet result = stat.executeQuery("SELECT @IDENTITY")){ // Get the ID from last query
                if(result.next())
                    return result.getInt(1);    // Returns the ID
            }
        } catch(IOException|SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    @Override
    public Activity getElement(int t_id) {
        return null;
    }

    @Override
    public List<Activity> getElementsFromDB() throws SQLException, IOException {
        return null;
    }

    @Override
    public boolean deleteElement(int t_id) {
        return false;
    }
}
