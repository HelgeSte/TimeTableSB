package com.stegemoen.timetable.domain;

import com.stegemoen.timetable.repo.CompanyRepository;
import com.stegemoen.timetable.repo.ContactRepository;
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
    ContactRepository contactRepository;
    @Autowired
    private ProjectRepository projectRepository;

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
    public void simpleCompanyContactCrudExample() {
        Company apple = new Company("Apple");
        Company ms = new Company("Microsoft");

        companyRepository.save(apple);
        companyRepository.save(ms);

        System.out.println("************ Original Companies ************");
        companyRepository.findAll().forEach(System.out::println);

        companyRepository.deleteAll();
        System.out.println("************ Companies removed ************");
        companyRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void simpleCompanyProjectCrudExample() {
        Company lamborghini = new Company("Lamborghini");
        Company ferrari = new Company("Ferrari");
        companyRepository.saveAll(List.of(lamborghini,ferrari));

        Employee peter = new Employee(new Person("Peter", "Griffin"),
                32);
        Employee daisy = new Employee(new Person("Daisy", "Duck"), 29);
        employeeRepository.saveAll(List.of(peter, daisy));


        Project fh5 = new Project("Make sure no cars are changed", peter, lamborghini);
        Project fh5interior = new Project("Control interiors in FH5", daisy, ferrari);

        projectRepository.saveAll(List.of(fh5, fh5interior));

        System.out.println("************ Original Projects ************");
        projectRepository.findAll().forEach(System.out::println);

        projectRepository.deleteAll();
        System.out.println("************ Projects removed ************");
        projectRepository.findAll().forEach(System.out::println);
    }
}
