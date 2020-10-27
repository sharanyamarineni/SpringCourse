package com.zemoso.springdemo;

public class MyApp {

	public static void main(String[] args) {
		Coach baseball = new BaseBallCoach();
		Coach track = new TrackCoach();
		System.out.println(baseball.getDailyWorkout());

	}

}
