package com.zemoso.springdemo;

public class CricketCoach implements Coach {
	private String EmailAddress;
	private String team;
	
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		System.out.println("setEmaiAddress ");
		EmailAddress = emailAddress;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		System.out.println("setTeam ");
		this.team = team;
	}
	public CricketCoach() {
		System.out.println("cricketCoach constructor");
	}
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("setFortuneservice setter");
		this.fortuneService = fortuneService;
	}
	private FortuneService fortuneService;
	@Override
	public String getDailyWorkout() {
		return "daily for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
