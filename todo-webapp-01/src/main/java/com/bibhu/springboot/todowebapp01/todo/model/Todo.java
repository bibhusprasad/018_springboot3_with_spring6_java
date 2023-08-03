package com.bibhu.springboot.todowebapp01.todo.model;


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
public class Todo {
    private long id;
    private String username;
    @Size(min = 5, message = "At least 5 characters" )
    private String description;
    private LocalDate targetDate;
    private String completed;
}
