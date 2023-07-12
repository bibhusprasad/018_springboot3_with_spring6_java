package com.bibhu.springboot.learnjpaandhibernate01.dao.datajpa;

import com.bibhu.springboot.learnjpaandhibernate01.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class CourseDataJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(21, "Learn GCP", "in28min"));
        repository.save(new Course(22, "Learn Azure", "in28min"));
        repository.save(new Course(23, "Learn Spring Boot", "in28min"));

        repository.deleteById(21L);

        System.out.println(repository.findById(22L));
        System.out.println(repository.findById(23L));

        System.out.println(repository.findAll());

        System.out.println(repository.findByAuthor("in28min"));
        System.out.println(repository.findByName("Learn Spring Boot"));
    }
}
