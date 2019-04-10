package com.example.rest.swagger.verona.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@ApiModel(description = "Class representing a person tracked by the application.")
@Data
@Entity
public class Person {


    @Id
    @ApiModelProperty(notes = "Unique identifier of the person. No two persons can have the same id.",required = true, position = 0)
    private int id;

    @ApiModelProperty(notes = "First name of the person.", required = true, position = 1)
    private String firstName;

    @ApiModelProperty(notes = "Last name of the person.", required = true, position = 2)
    private String lastName;

    @ApiModelProperty(notes = "Age of the person. Non-negative integer", position = 3)
    private int age;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}