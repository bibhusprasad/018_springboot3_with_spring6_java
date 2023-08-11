package com.bibhu.springboot.restfulwebservice01.user.controller;

import com.bibhu.springboot.restfulwebservice01.user.exception.UserNotFoundException;
import com.bibhu.springboot.restfulwebservice01.user.model.User;
import com.bibhu.springboot.restfulwebservice01.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAllUser(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable Long id){
        User user = userService.findByUserId(id);
        if(null == user){
            throw new UserNotFoundException("id = " + id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
