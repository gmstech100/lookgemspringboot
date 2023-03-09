package com.example.lookgem.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lookgem.exception.ResourceNotFoundException;
import com.example.lookgem.model.GemWatch;
import com.example.lookgem.model.Note;
import com.example.lookgem.repository.GemWatchJpaRepository;
import com.example.lookgem.repository.GemWatchRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class GemWatchController {

    @Autowired
    GemWatchRepository gemWatchRepository;
    
    @Autowired
    GemWatchJpaRepository gemWatchJpaRepository;
    
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
    
    @PostMapping("/gemwatching")
    public GemWatch createGemWatching(@Valid @RequestBody GemWatch gemWatch) {
        return gemWatchJpaRepository.save(gemWatch);
    }
    
    @DeleteMapping("/gemwatching")
    public ResponseEntity<?> deleteNotes(@RequestParam(value = "id") Long[] gemWatchIds) {
        for (Long gemWatchId : gemWatchIds) {
        	GemWatch gemWatch = gemWatchJpaRepository.findById(gemWatchId)
                    .orElseThrow(() -> new ResourceNotFoundException("GemWatch", "id", gemWatchId));
            gemWatchJpaRepository.delete(gemWatch);
        }
        return ResponseEntity.ok().build();
    }

}
