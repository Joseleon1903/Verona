package com.example.rest.swagger.verona.model;

import lombok.Data;

@Data
public class MakeTransactRequest {

    private String originAccount;

    private String destinationAccount;

    private double amount;

    public MakeTransactRequest(){}


}
