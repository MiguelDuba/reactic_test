package com.mad.reactive.apitest.model;

public class NewPerson {
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String lastName;
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public NewPerson(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public NewPerson() {
    }
}
