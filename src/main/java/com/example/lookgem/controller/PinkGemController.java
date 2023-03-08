package com.example.lookgem.controller;

import com.example.lookgem.exception.ResourceNotFoundException;
import com.example.lookgem.model.Note;
import com.example.lookgem.model.PinkGem;
import com.example.lookgem.repository.NoteRepository;
import com.example.lookgem.repository.PinkGemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PinkGemController {

    @Autowired
    PinkGemRepository pinkGemRepository;
    
    @GetMapping("/pinkgems/all")
    public ResponseEntity<List<PinkGem>> getPinkGemAll() {

        List<PinkGem> pinkGems = pinkGemRepository.getPinkGemAll();

        if (pinkGems.isEmpty()) {
            //return ResponseEntity.notFound().build();
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
            //return ResponseEntity.notFound().build();
        	return ResponseEntity.ok(Collections.emptyList());
        } else {
            return ResponseEntity.ok(pinkGems);
        }
    }

}
