package com.example.jayy2kok.caching.cachingdemo.controller;

import java.util.concurrent.ExecutionException;

import com.example.jayy2kok.caching.cachingdemo.model.Person;
import com.example.jayy2kok.caching.cachingdemo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping(value="persons")
    public Flux<Person> getPersons() {
        return personService.findAll();
    }

    @GetMapping(value="persons/{name}")
    public Person getPersonByName(@PathVariable String name) throws InterruptedException, ExecutionException {
        return personService.findByName(name);
    }
    
}
