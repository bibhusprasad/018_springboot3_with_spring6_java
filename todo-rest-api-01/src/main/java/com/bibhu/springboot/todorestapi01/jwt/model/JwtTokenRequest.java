package com.bibhu.springboot.todorestapi01.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenRequest {

    private String username;
    private String password;
}
