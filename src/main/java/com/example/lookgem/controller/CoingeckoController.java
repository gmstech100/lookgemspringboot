package com.example.lookgem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lookgem.model.CoingeckoNewCurrency;
import com.example.lookgem.repository.CoingeckoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CoingeckoController {

   
	@Autowired
	CoingeckoRepository coingeckoRepository;

    @GetMapping("/coingeckonewcurrencies")
    public List<CoingeckoNewCurrency> getAllCoingeckoNewCurrency() {
        return coingeckoRepository.findAll();
    }
}
