package com.example.rest.swagger.verona.repository;

import com.example.rest.swagger.verona.model.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long>{


}