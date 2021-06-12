package com.example.jayy2kok.caching.cachingdemo.config;

import java.util.Arrays;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

//@Component
public class CacheCustomizer 
  implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

   // @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        cacheManager.setCacheNames(Arrays.asList("persons"));
    }
}
