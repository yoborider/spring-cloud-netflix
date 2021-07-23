package com.thales.techaway.netflixstack.cardealership.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @CircuitBreaker(name = "testFallback", fallbackMethod = "getNumberOfCarsInStockFallback" )
    public int getNumberOfCarsInStock() {
        //return restTemplate.getForObject("http://stock-service/count", Integer.class);
        return restTemplate.getForObject("http://spring-api-gateway/count", Integer.class);
    }

    private int getNumberOfCarsInStockFallback(Throwable t) {
        return 50;
    }
}
