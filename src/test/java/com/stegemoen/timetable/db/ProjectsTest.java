package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.model.Project;
import com.stegemoen.timetable.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectsTest {
    private static Project project;
    @Test
    public void createProject(){
        User homer = new User("Homer", "Simpson", "homie@simps.rus", "123");
        Customer duff = new Customer("Duff Beer");
        project = new Project("Saving monday evening", duff, homer);
        int projectId = new Projects().saveToDb(project);
        assertEquals("Homer", project.getProjectManager().getFirstName());
    }

    @Test
    public void addProjectToDB(){
        new Projects().saveToDb(project);
    }

    @Test
    public void testLoadProjectsFromDB(){
        // ToDo, test if contains activty from previous test
    }

    @Test
    public void testFindProject(){
        // Use method that use SELECT to find one specific Project
    }

}