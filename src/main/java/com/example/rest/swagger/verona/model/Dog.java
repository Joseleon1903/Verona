package com.example.rest.swagger.verona.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Dog{

    @Id
    private long id;
    private String name;
    private int age;

    public Dog(){}

    public Dog(String name, int age){
        this.name = name;
        this.age =age;
    }




}