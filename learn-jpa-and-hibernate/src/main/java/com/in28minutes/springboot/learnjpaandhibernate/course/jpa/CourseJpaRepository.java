package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
/*
 * 1. mapping of java bean to relational table form
 * 2. then create this repository... and perform following steps 
 * 3. Use EntityManager for jpa for talking to database 
 * as we use SpringJdbc template class for spring jdbc. 
 * */
@Repository
@Transactional
public class CourseJpaRepository {
	// when working with jpa we require EntityManager to manage that entity
	 @PersistenceContext 
     private EntityManager entityManager;
     
     public void insert(Course course){
    	 entityManager.merge(course);
     }
     public Course findById(long id){
    	 return entityManager.find(Course.class, id);
     }
     public void deleteById(long id) {
    	 Course course = entityManager.find(Course.class, id);
    	 entityManager.remove(course);
     }
     
}
