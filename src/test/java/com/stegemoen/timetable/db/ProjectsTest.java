package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.model.Project;
import com.stegemoen.timetable.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectsTest {
    private static Project project;
    private static User homer;
    private static Customer duff;
    private static int projectId = 0;
    private static int uid = 0;
    private static int cid = 0;


    @BeforeAll
    public static void beforeAll(){
        homer = new User("Homer", "Simpson", "homie@simps.rus", "123");
        duff = new Customer("Duff Beer");
        project = new Project("Saving monday evening", duff, homer);
        cid = (new Customers()).saveToDB(duff);
        uid = (new Users()).saveToDB(homer);
        projectId = (new Projects()).saveToDb(project, cid, uid);
    }

    @Test
    public void testCustomerAddedToDB(){
        assertTrue(cid > 0);
    }

    @Test
    public void testUserAddedToDB(){
        assertTrue(uid > 0);
    }
    @Test
    public void testProjectAddedToDB(){
        assertTrue(projectId > 0);
    }

    @Test
    public void testObjectsCreated(){
        assertEquals("Homer", project.getProjectManager().getFirstName());
        assertEquals("Duff Beer", duff.getCompanyName());
        assertEquals("Saving monday evening", project.getProjectName());
    }

    @Test
    public void testLoadProjectsFromDB(){
        // ToDo, test if contains activty from previous test
    }

}