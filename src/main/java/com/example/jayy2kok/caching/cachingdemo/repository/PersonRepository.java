package com.example.jayy2kok.caching.cachingdemo.repository;

import com.example.jayy2kok.caching.cachingdemo.model.Person;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, ObjectId>{
    Flux<Person> findAll();

    Mono<Person> findByName(String name);
}
