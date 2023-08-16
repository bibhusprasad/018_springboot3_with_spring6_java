package com.bibhu.springboot.restfulwebservice01.user.controller;

import com.bibhu.springboot.restfulwebservice01.user.exception.UserNotFoundException;
import com.bibhu.springboot.restfulwebservice01.user.model.User;
import com.bibhu.springboot.restfulwebservice01.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAllUser(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> findUserById(@PathVariable Long id){
        User user = userService.findByUserId(id);
        if(null == user){
            throw new UserNotFoundException("id = " + id);
        }
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findAllUser());
        userEntityModel.add(link.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.createUser(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserBy(id);
    }


}
