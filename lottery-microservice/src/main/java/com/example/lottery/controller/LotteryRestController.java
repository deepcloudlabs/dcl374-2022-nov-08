package com.example.lottery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lottery.service.LotteryService;

@RestController
@RequestMapping("/numbers")
public class LotteryRestController {
	@Value("${lotteryMax}")
	private int lotteryMax;
	
	@Value("${lotterySize}")
	private int lotterySize;
	
	private final LotteryService lotteryService;
	
	public LotteryRestController(LotteryService lotteryService) {
		this.lotteryService = lotteryService;
	}

	@GetMapping(params="column")
	public List<List<Integer>> draw(
		@RequestParam	int column){
		return lotteryService.draw(lotteryMax, lotterySize,column);
	}
}
