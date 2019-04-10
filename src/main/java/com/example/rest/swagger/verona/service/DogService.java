package com.example.rest.swagger.verona.service;

import java.util.ArrayList;
import java.util.List;
import com.example.rest.swagger.verona.model.Dog;
import com.example.rest.swagger.verona.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService{

    @Autowired
    private DogRepository dogRepository;

    public Dog guardar(Dog dog){
        return dogRepository.save(dog);
    }

    public void delete(long id){
        dogRepository.deleteById(id);
    }

    public Dog buscarPorId(long id){
        return dogRepository.findById(id).get();
    }

    public List<Dog> buscarTodos(){
        Iterable<Dog> iterableList = dogRepository.findAll();
        if(iterableList != null){
            return (List)dogRepository.findAll();
        }
        return new ArrayList<>();
     }


    




}