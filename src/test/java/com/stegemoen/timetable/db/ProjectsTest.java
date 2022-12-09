package com.stegemoen.timetable.db;

import com.stegemoen.timetable.model.Customer;
import com.stegemoen.timetable.model.Employee;
import com.stegemoen.timetable.model.Project;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectsTest {
    private static Project project;
    private static Employee homer;
    private static Customer duff;
    private static int projectId = 0;
    private static int uid = 0;
    private static int cid = 0;


    @BeforeAll
    public static void beforeAll(){
        homer = new Employee("Homer", "Simpson", "fake@fakeemail12345.com", "123");
        duff = new Customer("The Fake Duff Beer");
        project = new Project("The Fake Project", duff, homer);
        cid = (new Customers()).saveToDB(duff);
        uid = (new Employees()).saveToDB(homer);
        projectId = (new Projects()).saveToDB(project, cid, uid);
    }

    @Test
    public void testCustomerAddedToDB(){
        assertTrue(cid > 0);
    }

    @Test
    public void testEmployeeAddedToDB(){
        assertTrue(uid > 0);
    }
    @Test
    public void testProjectAddedToDB(){
        assertTrue(projectId > 0);
    }

    @Test
    public void testObjectsCreated(){
        assertEquals("fake@fakeemail12345.com", project.getProjectManager().getEmail());
        assertEquals("The Fake Duff Beer", duff.getCompanyName());
        assertEquals("The Fake Project", project.getProjectName());
    }

    @Test
    public void testLoadProjectsFromDB(){
        var pList = (new Projects()).getElementsFromDB();
    }

    @Test
    public void testDeleteProject(){
        var plist = (new Projects()).getElementsFromDB().stream()
                .filter(x -> x.getProjectName().equals("The Fake Project"))
                .collect(Collectors.toList());
        plist.stream().forEach(p -> (new Projects()).deleteElement(p.getProjectID()));
    }

    @AfterAll
    public static void deleteCustomerAndEmployee() throws IOException, SQLException {
        var addedEmployees = (new Employees()).getElementsFromDB().stream()
                .filter(x -> x.getEmail().equals("fake@fakeemail12345.com")).toList();
        var addedCustomers = (new Customers()).getElementsFromDB().stream()
                .filter(x -> x.getCompanyName().contains("The Fake Duff Beer")).toList();
    }
}