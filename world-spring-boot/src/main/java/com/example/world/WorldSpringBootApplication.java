package com.example.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import com.example.world.dao.WorldDao;

@SpringBootApplication
@EnableCaching
public class WorldSpringBootApplication implements ApplicationRunner{
	@Autowired private WorldDao worldDao;
	@Autowired private ApplicationContext container;
	
	public static void main(String[] args) {
		SpringApplication.run(WorldSpringBootApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.err.println(worldDao.getAllContinents());
		container.getBeansOfType(Object.class)
		         .forEach((name,component) -> {
		        	System.err.println("%36s: %16s".formatted(name, component.getClass().getSimpleName())); 
		         });
	}

}
