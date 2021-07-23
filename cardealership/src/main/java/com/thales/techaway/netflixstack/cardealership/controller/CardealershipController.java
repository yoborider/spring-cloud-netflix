package com.thales.techaway.netflixstack.cardealership.controller;

import com.thales.techaway.netflixstack.cardealership.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardealershipController {
    @Autowired
    private StockService stockService;

    @RequestMapping(value = "/available")
    public String available() {
        return String.format("There are %s cars available", stockService.getNumberOfCarsInStock());
    }
}
