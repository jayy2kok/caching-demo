package com.example.jayy2kok.caching.cachingdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class CachingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingDemoApplication.class, args);
	}

}
