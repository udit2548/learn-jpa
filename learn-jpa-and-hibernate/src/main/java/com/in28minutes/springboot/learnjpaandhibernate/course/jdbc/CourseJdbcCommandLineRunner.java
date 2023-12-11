package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
// main motive of this interface Command Line Runner is to fire the given sql query at the 
// startup of the application. 
// code is same in commandline runner even when using jpa, then use this
//@Autowired
//private CourseJpaRepository repo;
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repo;
	@Override
	
	// run method which is executed at the startup of the application
	public void run(String... args) throws Exception {
		repo.insert(new Course(1,"Learn Java NOW","in28minutes"));
		repo.insert(new Course(2,"Learn devops NOW","in28minutes"));
		repo.insert(new Course(3,"Learn kotlin NOW","in28minutes"));
		
		repo.deleteById(1);
		System.out.println(repo.selectbyId(2));
		System.out.println(repo.selectbyId(3));
		
		
		
	}
   
}
