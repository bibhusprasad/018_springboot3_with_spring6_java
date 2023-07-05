package com.bibhu.springboot.learnspringboot01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Course {
    private int id;
    private String name;
    private String author;
}
