package com.example.lookgem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lookgem.model.GemWatch;

public interface GemWatchJpaRepository extends JpaRepository<GemWatch, Long> {

}
