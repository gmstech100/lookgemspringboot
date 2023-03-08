package com.example.lookgem.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lookgem.model.GemWatch;
import com.example.lookgem.repository.GemWatchRepository;

@RestController
@RequestMapping("/api")
public class GemWatchController {

    @Autowired
    GemWatchRepository gemWatchRepository;
    
    @GetMapping("/gemwatching/all")
    public ResponseEntity<List<GemWatch>> getPinkGemAll() {

        List<GemWatch> GemWatch = gemWatchRepository.getGemWathchingAll();

        if (GemWatch.isEmpty()) {
        	return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(GemWatch);
        }
    }
    
    @GetMapping("/gemwatching")
    public ResponseEntity<List<GemWatch>> getPinkGemByCondition(
    		@RequestParam(name = "token", required = false) String token,
            @RequestParam(name = "tokenAddress", required = false) String tokenAddress,
            @RequestParam(name = "followers", required = false) int followers,
            @RequestParam(name = "dateListFrom", required = false) String dateListFrom,
            @RequestParam(name = "dateListTo", required = false) String dateListTo,
            @RequestParam(name = "chain", required = false) String chain,
            @RequestParam(name = "hasBscCall", required = false) String hasBscCall,
            @RequestParam(name = "hasShillSealsCall", required = false) String hasShillSealsCall,
            @RequestParam(name = "launchPad", required = false) String launchPad) {

        List<GemWatch> gemWatchs = gemWatchRepository.getGemWatchingByCondition(token, tokenAddress
        		, followers, dateListFrom, dateListTo, chain
        		, hasBscCall, hasShillSealsCall, launchPad);

        if (gemWatchs.isEmpty()) {
            //return ResponseEntity.notFound().build();
        	return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(gemWatchs);
        }
    }

}
