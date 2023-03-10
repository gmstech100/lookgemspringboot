package com.example.lookgem.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.example.lookgem.model.GemWatch;

public interface GemWatchRepository  {
	
    List<GemWatch> getGemWatchingByCondition(@Param("token") String token, @Param("tokenAddress") String tokenAddress
    		, @Param("followers") int followers, @Param("dateListFrom") String dateListFrom, @Param("dateListTo") String dateListTo, @Param("chain") String chain
    		, @Param("hasBscCall") String hasBscCall, @Param("hasShillSealsCall") String hasShillSealsCall, @Param("launchPad") String launchPad);
    List<GemWatch> getGemWathchingAll();

}
