package com.zemoso.springdemo;

public class BaseBallCoach  implements Coach{
	public BaseBallCoach() {
		
	}
	FortuneService fortuneService;
	
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout(){
		return "spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// using fortuneService to get a fortune
		return fortuneService.getFortune();
	}
}
