package com.example.lookgem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lookgem.model.PinkGem;

public interface PinkGemRepository  {
	
    List<PinkGem> getPinkGemByCondition(@Param("token") String token, @Param("tokenAddress") String tokenAddress
    		, @Param("followers") int followers, @Param("hasKyc") String hasKyc, @Param("hasPump") String hasPump);

}
