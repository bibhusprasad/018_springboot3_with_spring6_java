package com.bibhu.springboot.restfulwebservice01.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {

    private Long id;
    private String name;
    private LocalDate birthDate;
}
