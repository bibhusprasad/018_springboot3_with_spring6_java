package com.bibhu.springboot.learnspringboot01.controller;


import com.bibhu.springboot.learnspringboot01.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> retrieveAllCourses() {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "Learn AWS", "in28min"));
        courseList.add(new Course(2, "Learn DevOps", "in28min"));
        courseList.add(new Course(3, "Learn Azure", "in28min"));
        return courseList;
    }

}
