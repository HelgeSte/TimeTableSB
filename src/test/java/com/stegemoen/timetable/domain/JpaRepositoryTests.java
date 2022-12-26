package com.stegemoen.timetable.domain;

import com.stegemoen.timetable.repo.CompanyRepository;
import com.stegemoen.timetable.repo.EmployeeRepository;
import com.stegemoen.timetable.repo.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaRepositoryTests {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ProjectRepository projectRepository;


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
