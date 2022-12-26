package com.stegemoen.timetable.repo;

import com.stegemoen.timetable.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
