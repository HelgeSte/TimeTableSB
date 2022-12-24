package com.stegemoen.timetable.repo;

import com.stegemoen.timetable.domain.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
