package com.stegemoen.timetable.util;

import com.stegemoen.timetable.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ActivityRepository activityRepository;
    private final CompanyRepository companyRepository;
    private final ContactRepository contactRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public AppStartupEvent(ActivityRepository activityRepository,
                           CompanyRepository companyRepository,
                           ContactRepository contactRepository,
                           EmployeeRepository employeeRepository,
                           ProjectRepository projectRepository) {
        this.activityRepository = activityRepository;
        this.companyRepository = companyRepository;
        this.contactRepository = contactRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Activity> activities = this.activityRepository.findAll();
        Iterable<Company> companies = this.companyRepository.findAll();
        Iterable<Contact> contacts = this.contactRepository.findAll();
        Iterable<Employee> employees = this.employeeRepository.findAll();
        Iterable<Project> projects = this.projectRepository.findAll();

        activities.forEach(System.out::println);
        companies.forEach(System.out::println);
        contacts.forEach(System.out::println);
        employees.forEach(System.out::println);
        projects.forEach(System.out::println);
    }
}
