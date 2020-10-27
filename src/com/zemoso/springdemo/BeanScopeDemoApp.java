package com.zemoso.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach",Coach.class);
		Coach aplhaCoach = context.getBean("myCoach",Coach.class);
		
		//check if both are same
		boolean result = (theCoach==aplhaCoach);
		
		System.out.println("\n pointing to same objects= "+result);
		System.out.println("memory location of theCoach= "+ theCoach);
		System.out.println("memory location of alphaCoach= "+ aplhaCoach);
		
		//close context
		context.close();
	}

}
