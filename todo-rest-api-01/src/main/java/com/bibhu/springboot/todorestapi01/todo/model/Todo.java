package com.bibhu.springboot.todorestapi01.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {

    private long id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private boolean completed;

    public Todo(String username, String description, LocalDate targetDate, boolean completed) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.completed = completed;
    }
}
