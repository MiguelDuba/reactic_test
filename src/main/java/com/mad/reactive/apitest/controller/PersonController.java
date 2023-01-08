package com.mad.reactive.apitest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.mad.reactive.apitest.model.NewPerson;
import com.mad.reactive.apitest.model.Person;
import com.mad.reactive.apitest.repo.PersonRepo;

import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.IntStream;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private Faker faker = new Faker();

    @Autowired
    private PersonRepo personRepo;


    @GetMapping("/{id}")
    public Mono<Person> getPersonById(@PathVariable String id){
        return personRepo.findById(UUID.fromString(id));
    }
    

    @GetMapping
    private Flux<Person> getAllEmployees() {
        return personRepo.findAll();
    }

    @PostMapping
    public Mono<Person> createPerson(@RequestBody NewPerson newPerson){
        var person = new Person(newPerson.getName(), newPerson.getLastName());
        return personRepo.save(person);
    }

    @PostMapping("/faker/{size}")
    public Flux<Person> createRandomPerson(@PathVariable int size){
        var newList = new ArrayList<Person>();
        for (int i = 0; i < size; i++) {
            newList.add(new Person(faker.name().firstName(), faker.name().lastName()));
        }
        return personRepo.saveAll(newList);
    }
}
