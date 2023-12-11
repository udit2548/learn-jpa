package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
/*
 jdbc involves more java code while spring jdbc involves less java code and we focus more 
 on sql queries and business logic.
 */
// to fire the simple sql query(hard-coded data) using spring jdbc
// step1: make use of JdbcTemplate class 
// step2: make use of CommandLineRunner to launch up the query at the start up of the application

@Repository
public class CourseJdbcRepository {
	@Autowired
    private JdbcTemplate springjdbcTemplate;
	// example of hard-coded data
//    private static String INSERT_QUERY =
//    		"""
//    		insert into course (id,name,author) 
//    		values(2,'Learn AWS','in28minutes');
//    		""";
/*  public void insert(){
 *    springjdbcTemplate.update(INSERT_QUERY);
 * }
 */
	private static String INSERT_QUERY ="""
			  insert into course(id,name,author)
			  values(?,?,?);
			""";
	private static String DELETE_QUERY ="""
			delete from course where id=?;
			""";
	private static String SELECT_QUERY ="""
			select * from course where id=?;
			""";
    public void insert(Course course){
    	springjdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
 
    }
    public void deleteById(long id){
    	springjdbcTemplate.update(DELETE_QUERY,id);
    }
    public Course selectbyId(long id){
    	// Result-set -->to--> bean mapping <Row Mappers>
    	return 
    	springjdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
    }
}
