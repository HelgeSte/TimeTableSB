package com.stegemoen.timetable.domain;

import com.stegemoen.timetable.repo.CompanyRepository;
import com.stegemoen.timetable.repo.EmployeeRepository;
// import org.junit.jupiter.api.Test; // Intelli-J adds this import and it fails with Spring Boot test
import com.stegemoen.timetable.repo.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryTests {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void simpleEmployeCrudExample() {
        employeeRepository.save(new Employee(new Person("Jane", "Doe"), 20));
        employeeRepository.save(new Employee(new Person("John", "Doe"), 22));
        employeeRepository.save(new Employee(new Person("Mike", "Smith"), 18));
        employeeRepository.save(new Employee(new Person("Ally", "Kim"), 19));

        System.out.println("************ Original Employees ************");
        employeeRepository.findAll().forEach(System.out::println);

        // age up the employees
        employeeRepository.findAll().forEach(employee -> {
            employee.setAge(employee.getAge() + 1);
            employeeRepository.save(employee);
        });

        System.out.println("************ Employees a year older ************");
        employeeRepository.findAll().forEach(System.out::println);

        employeeRepository.deleteAll();
        System.out.println("************ Employees removed ************");
        employeeRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void simpleProjectActivityCrudExample() {

        // replacing contact objects with Strings
        String mickey = "Mickey Mouse";
        String linus = "Linus Torvalds";
        // have simplified companies, to avoid 2 foreign id's in the company class
        Company linux = new Company("Linux", mickey);
        Company disney = new Company("Disney", linus);

        companyRepository.save(linux);
        companyRepository.save(disney);
        Project project = new Project(
                "The Linux Documentation Project", true, linux);
        System.out.println("Saving project");
        projectRepository.save(project);

        projectRepository.findAll().forEach(System.out::println);
        System.out.println("Deleting projects");
        projectRepository.deleteAll();
        projectRepository.findAll().forEach(System.out::println);


    }
}
