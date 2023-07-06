package com.bibhu.springboot.learnjpaandhibernate01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    private long id;
    private String name;
    private String author;
}
