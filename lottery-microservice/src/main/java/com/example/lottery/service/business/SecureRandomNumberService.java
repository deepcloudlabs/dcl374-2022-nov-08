package com.example.lottery.service.business;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.stereotype.Service;

import com.example.lottery.service.Quality;
import com.example.lottery.service.QualityLevel;
import com.example.lottery.service.RandomNumberService;

@Service
@Quality(QualityLevel.SECURE)
//@Profile({"prod", "preprod"})
@ConditionalOnProperty(name = "lottery", havingValue = "secure")
@ConditionalOnCloudPlatform(CloudPlatform.AZURE_APP_SERVICE)
public class SecureRandomNumberService implements RandomNumberService {
	private Random random = new SecureRandom();

	@Override
	public int generate(int min, int max) {
		System.err.println("SecureRandomNumberService::generate");
		return random.nextInt(min, max);
	}

}
