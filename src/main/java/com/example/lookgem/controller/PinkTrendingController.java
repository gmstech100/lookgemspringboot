package com.example.lookgem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lookgem.model.PinkTrending;
import com.example.lookgem.repository.PinkTrendingRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PinkTrendingController {

   
	@Autowired
	PinkTrendingRepository pinkTrendingRepository;

    @GetMapping("/pinktrending")
    public List<PinkTrending> getAllPinkTrending() {
        return pinkTrendingRepository.findAll();
    }

}
