package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    public static List<Activity> getList(){
        List<Activity> activities = new ArrayList<>();
        // ToDo: load all from db
        return activities;
    }

    public static void saveToDB(Activity activity){
        try {
            // noe
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
