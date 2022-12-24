package com.stegemoen.timetable.domain;

import com.stegemoen.timetable.repo.EmployeeRepository;
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryTests {

    @Autowired
    EmployeeRepository employeeRepository;

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
}
