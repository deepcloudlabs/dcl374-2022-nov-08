package com.example.world.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.world.dao.WorldDao;
import com.example.world.domain.Country;

@RestController
//@RequestScope // meta-annotation
// @Scope("request")
@Validated
@CrossOrigin
public class WorldRestController {
	// @Autowired // 2. Field Injection
	private WorldDao worldDao;
	
	// 1. Constructor Injection
	/*
	public WorldRestController(WorldDao worldDao) {
		this.worldDao = worldDao;
	}
    */
	
	@Autowired // 3. Setter Injection
	public void setWorldDao(WorldDao worldDao) {
		System.err.println("WorldRestController::setWorldDao(WorldDao worldDao)");
		this.worldDao = worldDao;
	}	
	
	// GET http://localhost:7100/world/api/v1/continents
	@GetMapping("/continents")
	public Set<String> getAllContinents(){
		return worldDao.getAllContinents();
	}
	

	// GET http://localhost:7100/world/api/v1/countries?continent=Asia
	@GetMapping("/countries")
	@Cacheable(cacheNames = "countries", key = "#continent")
	public List<Country> getAllCountriesByContinent(
			@RequestParam String continent,
			@RequestParam(required = true,defaultValue = "0") int pageNo,
			@RequestParam(required = true,defaultValue = "10") int pageSize){
		System.err.println("WorldRestController::getAllCountriesByContinent");
		return worldDao.findCountriesByContinent(continent)
				       .stream()
				       .skip(pageNo*pageSize)
				       .limit(pageSize)
				       .toList();
	}
}
