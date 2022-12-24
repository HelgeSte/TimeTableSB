package com.stegemoen.timetable.repo;

import com.stegemoen.timetable.domain.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
}
