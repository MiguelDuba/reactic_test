package com.mad.reactive.apitest.repo;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.mad.reactive.apitest.model.Person;


public interface PersonRepo extends ReactiveCrudRepository<Person, UUID>{}
