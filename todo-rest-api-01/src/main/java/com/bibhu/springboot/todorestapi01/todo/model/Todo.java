package com.bibhu.springboot.todorestapi01.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
