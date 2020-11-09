package com.zemoso.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zemoso.hibernate.demo.entity.Course;
import com.zemoso.hibernate.demo.entity.Instructor;
import com.zemoso.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {
	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Instructor.class)
										.addAnnotatedClass(InstructorDetail.class)
										.addAnnotatedClass(Course.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					Instructor tempInstructor = 
							new Instructor("sony", "williams", "sony@gmail.com");
					
					InstructorDetail tempInstructorDetail =
							new InstructorDetail(
									"http://www.youtube.com",
									"guitar");		
					
					// associate the objects
					tempInstructor.setInstructorDetail(tempInstructorDetail);
					
					// start a transaction
					session.beginTransaction();
					
					// save the instructor
					//
					// Note: this will ALSO save the details object
					// because of CascadeType.ALL
					//
					System.out.println("Saving instructor: " + tempInstructor);
					session.save(tempInstructor);					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
	}
}
