package com.stegemoen.timetable.repo;

import com.stegemoen.timetable.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
