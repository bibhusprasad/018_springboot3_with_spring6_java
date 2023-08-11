package com.bibhu.springboot.restfulwebservice01.user.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ErrorDetails {

    private LocalDateTime timeStamp;
    private String message;
    private String details;

}
