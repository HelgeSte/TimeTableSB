package com.stegemoen.timetable.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    private Integer employeeId;

    @Column
    private Integer age;

    @Embedded
    private Person person;

    public Employee(Person person, Integer age) {
        this.person = person;
        this.age = age;
    }

    protected Employee(){}

    @OneToMany(mappedBy="employee", // company from ManyToOne mapping in Contact
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Project> projectList = new ArrayList<>();

    public Employee(Integer employeeId, Integer age, Person person) {
        this.employeeId = employeeId;
        this.age = age;
        this.person = person;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", age=" + age +
                ", person=" + person +
                '}';
    }
}
