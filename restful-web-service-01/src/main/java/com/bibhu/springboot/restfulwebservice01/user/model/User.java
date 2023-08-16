package com.bibhu.springboot.restfulwebservice01.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2, message = "Name should have atleast 2 characters")
    @JsonProperty(value = "user_name")
    private String name;
    @Past(message = "Birthdate should be in Past")
    @JsonProperty(value = "user_birth_date")
    private LocalDate birthDate;
}
