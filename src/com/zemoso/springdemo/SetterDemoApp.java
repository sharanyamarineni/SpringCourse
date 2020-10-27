package com.zemoso.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		CricketCoach thecoach = context.getBean("myCricketCoach",CricketCoach.class);
		
		//call methods on bean
		System.out.println(thecoach.getDailyWorkout());
		
		System.out.println(thecoach.getDailyFortune());
		
		
		System.out.println(thecoach.getEmailAddress());
		System.out.println(thecoach.getTeam());
		//close the context
		context.close();
	}

}
