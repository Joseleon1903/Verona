package com.example.rest.swagger.verona.service;

import com.example.rest.swagger.verona.model.Person;
import com.example.rest.swagger.verona.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    void init() {

        Person john = new Person(1, "John", "Smith", 42);
        personRepository.save(john);

        Person jane = new Person(2, "Jane", "Jonhnson", 19);
        personRepository.save(jane);

        Person kate = new Person(3, "Kate", "Jones", 33);
        personRepository.save(kate);
    }

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public Person getPersonById(int id) {
        return personRepository.findById(id).get();
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}