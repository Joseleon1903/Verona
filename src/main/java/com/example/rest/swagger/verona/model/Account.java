package com.example.rest.swagger.verona.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Account {

    @Id
    private int id;

    private int accountId;

    private String accountNumber;

    private double balance;

    public Account(){

    }




}
