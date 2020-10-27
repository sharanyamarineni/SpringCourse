package com.zemoso.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		Coach thecoach = context.getBean("myCoach",Coach.class);
		
		//call methods on bean
		System.out.println(thecoach.getDailyWorkout());
		
		System.out.println(thecoach.getDailyFortune());
		
		//close the context
		context.close();
		
	}

}
