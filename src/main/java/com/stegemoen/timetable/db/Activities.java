package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Activity;
import com.stegemoen.timetable.model.Employee;
import com.stegemoen.timetable.model.Project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Activities implements iTimeTableDB<Activity> {
    public int saveToDB(Activity a, int pid, int eid) {
        List<Activity> activities = new ArrayList<>();
        String a_startDate = String.format("%s-%s-%s",
                a.getStartTime().getYear(), a.getStartTime().getMonthValue(), a.getStartTime().getDayOfMonth());
        String a_startTime = String.format("%s:%s:%s",
                a.getStartTime().getHour(), a.getStartTime().getMinute(), 0);
        String a_endDate = String.format("%s-%s-%s",
                a.getEndTime().getYear(), a.getEndTime().getMonthValue(), a.getEndTime().getDayOfMonth());
        String a_endTime = String.format("%s:%s:%s",
                a.getEndTime().getHour(), a.getEndTime().getMinute(), 0);
        try(Connection conn = DbUtilities.getConnection();
        Statement stat = conn.createStatement()){
            String inputQuery = String.format(
                    "INSERT INTO activities(Text, Start, End, ProjectID, EmployeeID) " +
                            "VALUES ('%s', '%s %s','%s %s', %d, %d);",
                    a.getComment(),
                    a_startDate,
                    a_startTime,
                    a_endDate,
                    a_endTime,
                    pid,
                    eid
            );
            stat.executeUpdate(inputQuery);
            try(ResultSet result = stat.executeQuery("SELECT @@IDENTITY")){ // Get the ID from last query
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
