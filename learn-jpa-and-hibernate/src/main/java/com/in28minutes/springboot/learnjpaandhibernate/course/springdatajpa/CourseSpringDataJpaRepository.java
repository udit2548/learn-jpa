package com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

// This is even more simpler, in this spring data jpa will handle entity manager mapping operations etc.
public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long>{
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
    
}
