package com.mad.reactive.apitest.model;

import org.springframework.data.annotation.Id;

public class Person {

    @Id
    public Long id;
    public String name;
    public String lastName;

    public Person(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    public Person(Long id, String name, String lastName){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public Person(){}
}
