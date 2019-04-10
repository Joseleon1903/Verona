package com.example.rest.swagger.verona.repository;

import com.example.rest.swagger.verona.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
