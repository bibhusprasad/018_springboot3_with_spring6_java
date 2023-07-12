package com.bibhu.springboot.learnjpaandhibernate01.dao.jpa;

import com.bibhu.springboot.learnjpaandhibernate01.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CourseJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(11, "Learn GCP", "in28min"));
        repository.insert(new Course(12, "Learn Azure", "in28min"));
        repository.insert(new Course(13, "Learn Spring Boot", "in28min"));

        System.out.println(repository.findById(11));

        repository.deleteById(13);
    }
}
