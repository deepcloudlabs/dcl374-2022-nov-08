package com.example.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// -Dspring.profiles.active=test
@SpringBootApplication
public class LotteryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotteryMicroserviceApplication.class, args);
	}

}
