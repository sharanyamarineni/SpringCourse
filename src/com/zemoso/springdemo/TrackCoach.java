package com.zemoso.springdemo;

public class TrackCoach implements Coach {
	public TrackCoach() {
		
	}
	
	FortuneService fortuneService;
	
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Just fo it "+fortuneService.getFortune();
	}
	
	public void init() {
		System.out.println("adding stuff");
	}

	public void destroy() {
		System.out.println("cleaning stuff");
	}
}
