package com.bibhu.springboot.learnjpaandhibernate01.dao.jdbc;

import com.bibhu.springboot.learnjpaandhibernate01.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args){
        //repository.insertQuery();

        repository.insertCourse(new Course(2, "Learn GCP", "in28min"));
        repository.insertCourse(new Course(3, "Learn Azure ", "in28min"));
        repository.insertCourse(new Course(4, "Learn Spring Boot ", "in28min"));

        System.out.println(repository.fetchAllCourse());

        repository.deleteById(4);

        System.out.println(repository.fetchCourseById(2));
        System.out.println(repository.fetchCourseById(3));
    }
}
