package com.stegemoen.timetable.repo;

import com.stegemoen.timetable.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
