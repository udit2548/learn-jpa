package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
//	This code is using spring jdbc 
//	@Autowired
//	private CourseJpaRepository repo;
/*
   @Override
	public void run(String... args) throws Exception {
     repo.insert();
     }
 */
	
	
@Autowired 
private CourseSpringDataJpaRepository repo; // indicating the use of spring data jpa 
// it also put the work of managing entity to put it in the background, hence reducing more lines
// code. Making jpa even more simpler by creating interface extending JpaRepository<Course,Long>
// by providing bunch of methods automatically.
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Course(4,"Learn Java Jpa","in28minutes"));
		repo.save(new Course(5,"Learn devops Jpa","in28minutes"));
		repo.save(new Course(6,"Learn kotlin Jpa","in28minutes"));
		
		repo.deleteById(4l);
		System.out.println(repo.findById(5l));
		System.out.println(repo.findById(6l));
		System.out.println(repo.findAll());
		System.out.println(repo.count());
		System.out.println(repo.findByAuthor("in28minutes"));
		System.out.println(repo.findByAuthor(""));
		
		
		
	}
       
}
