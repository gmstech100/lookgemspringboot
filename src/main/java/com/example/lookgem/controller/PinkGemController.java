package com.example.lookgem.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lookgem.model.PinkGem;
import com.example.lookgem.repository.PinkGemRepository;

@RestController
@RequestMapping("/api")
public class PinkGemController {

    @Autowired
    PinkGemRepository pinkGemRepository;
    
    @GetMapping("/pinkgems/all")
    public ResponseEntity<List<PinkGem>> getPinkGemAll() {

        List<PinkGem> pinkGems = pinkGemRepository.getPinkGemAll();

        if (pinkGems.isEmpty()) {
        	return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(pinkGems);
        }
    }
    
    @GetMapping("/pinkgems")
    public ResponseEntity<List<PinkGem>> getPinkGemByCondition(
    		@RequestParam(name = "token", required = false) String token,
            @RequestParam(name = "tokenAddress", required = false) String tokenAddress,
            @RequestParam(name = "followers", required = false) int followers,
            @RequestParam(name = "hasKyc", required = false) String hasKyc,
            @RequestParam(name = "hasPump", required = false) String hasPump) {

        List<PinkGem> pinkGems = pinkGemRepository.getPinkGemByCondition(token, tokenAddress, followers, hasKyc, hasPump);

        if (pinkGems.isEmpty()) {
        	return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(pinkGems);
        }
    }

}
