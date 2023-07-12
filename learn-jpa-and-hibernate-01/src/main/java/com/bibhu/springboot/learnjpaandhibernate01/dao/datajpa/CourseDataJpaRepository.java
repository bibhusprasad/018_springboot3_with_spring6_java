package com.bibhu.springboot.learnjpaandhibernate01.dao.datajpa;

import com.bibhu.springboot.learnjpaandhibernate01.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
}
