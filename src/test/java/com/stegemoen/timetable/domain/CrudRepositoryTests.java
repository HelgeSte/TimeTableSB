package com.stegemoen.timetable.domain;

import com.stegemoen.timetable.repo.CompanyRepository;
import com.stegemoen.timetable.repo.ContactRepository;
import com.stegemoen.timetable.repo.EmployeeRepository;
// import org.junit.jupiter.api.Test; // Intelli-J adds this import and it fails with Spring Boot test
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

        Contact bill = new Contact(new Person("Bill", "Gates"),
                "bill@ms.com","01",
                ms);
        Contact steve = new Contact(new Person("Steve", "Ballmer"),
                "steve.ballmer@microsoft.com", "02", ms);
        Contact jobs = new Contact(new Person("Steve", "Jobs"),
                "steve@apple.com", "1", apple);
        contactRepository.saveAll(List.of(bill, steve, jobs));

        System.out.println("************ Original Companies ************");
        companyRepository.findAll().forEach(System.out::println);

        companyRepository.deleteAll();
        System.out.println("************ Companies removed ************");
        companyRepository.findAll().forEach(System.out::println);
    }
}
