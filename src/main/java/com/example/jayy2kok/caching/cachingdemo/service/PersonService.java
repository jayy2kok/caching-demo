package com.example.jayy2kok.caching.cachingdemo.service;

import java.util.concurrent.ExecutionException;

import com.example.jayy2kok.caching.cachingdemo.model.Person;
import com.example.jayy2kok.caching.cachingdemo.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    CacheManager cacheManager;
   
    @Cacheable("persons")
    public Flux<Person>findAll(){
        //Example cacheble does not work on Flux
        return personRepository.findAll();
    }

    @Cacheable("person")
    public Person findByName(String name) throws InterruptedException, ExecutionException{
        //Example cacheble working when Mono is converted to actual type
        return personRepository.findByName(name).toFuture().get();
    }

    //Refresh the cache in a minute
    @Scheduled(fixedDelay = 60000)
    public void evictAllCaches() {
        cacheManager.getCacheNames().stream()
          .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }
}
