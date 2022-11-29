package com.example.lottery.service.business;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.Quality;
import com.example.lottery.service.QualityLevel;
import com.example.lottery.service.RandomNumberService;

@Service
@SuppressWarnings("unused")
public class StandardLotteryService implements LotteryService {
	private final List<RandomNumberService> randomNumberServices;
	private final Map<String, RandomNumberService> mapRandomNumberServices;
	private AtomicInteger counter = new AtomicInteger();

	public StandardLotteryService(
			//@Quality(QualityLevel.FAST) 
			List<RandomNumberService> randomNumberServices,
			Map<String, RandomNumberService> mapRandomNumberServices) {
		this.randomNumberServices = randomNumberServices;
		this.mapRandomNumberServices = mapRandomNumberServices;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		var index = counter.getAndIncrement() % randomNumberServices.size();
		var randomNumberService = randomNumberServices.get(index);
		return IntStream.generate(() -> randomNumberService.generate(max)).distinct().limit(size).sorted().boxed()
				.toList();
	}

	@Override
	public List<List<Integer>> draw(int max, int size, int column) {
		return IntStream.range(0, column).mapToObj(i -> draw(max, size)).toList();
	}

}
