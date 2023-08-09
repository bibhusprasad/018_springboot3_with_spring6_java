package com.bibhu.springboot.todowebapp01.todo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
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
    @Size(min = 5, message = "At least 5 characters" )
    private String description;
    private LocalDate targetDate;
    private String completed;

    public Todo(String username, String description, LocalDate targetDate, String completed) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.completed = completed;
    }
}
