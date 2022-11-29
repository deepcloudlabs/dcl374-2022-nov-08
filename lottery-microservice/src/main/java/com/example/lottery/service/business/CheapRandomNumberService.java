package com.example.lottery.service.business;

import java.util.Random;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.example.lottery.service.Quality;
import com.example.lottery.service.QualityLevel;
import com.example.lottery.service.RandomNumberService;

@Service
@Quality(QualityLevel.CHEAP)
//@Profile("test")
@ConditionalOnProperty(name="lottery",havingValue = "cheap")
public class CheapRandomNumberService implements RandomNumberService {
	private final Random random = new Random();
	@Override
	public int generate(int min, int max) {
		System.err.println("CheapRandomNumberService::generate");
		return random.nextInt(min, max);
	}

}
