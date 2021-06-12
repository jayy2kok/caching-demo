package com.example.jayy2kok.caching.cachingdemo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Persons")
public class Person {
    private String name;
    private int age;
}
