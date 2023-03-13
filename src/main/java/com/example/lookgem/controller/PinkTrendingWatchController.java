package com.example.lookgem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lookgem.exception.ResourceNotFoundException;
import com.example.lookgem.model.PinkTrendingWatch;
import com.example.lookgem.repository.PinkTrendingWatchRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class PinkTrendingWatchController {

   
	@Autowired
	PinkTrendingWatchRepository pinkTrendingWatchRepository;

    @GetMapping("/pinktrendingwatchs")
    public List<PinkTrendingWatch> getAllPinkTrendingWatch() {
        return pinkTrendingWatchRepository.findAll();
    }
    
    @PostMapping("/pinktrendingwatchs")
    public PinkTrendingWatch createPinkTrendingWatch(@Valid @RequestBody PinkTrendingWatch pinkTrendingWatch) {
        return pinkTrendingWatchRepository.save(pinkTrendingWatch);
    }
    
    @DeleteMapping("/pinktrendingwatchs")
    public ResponseEntity<?> deleteNotes(@RequestParam(value = "id") Long[] pinkTrendingWatchIds) {
        for (Long pinkTrendingWatchId : pinkTrendingWatchIds) {
        	PinkTrendingWatch pinkTrendingWatch = pinkTrendingWatchRepository.findById(pinkTrendingWatchId)
                    .orElseThrow(() -> new ResourceNotFoundException("PinkTrendingWatch", "id", pinkTrendingWatchId));
        	pinkTrendingWatchRepository.delete(pinkTrendingWatch);
        }
        return ResponseEntity.ok().build();
    }
    

}
