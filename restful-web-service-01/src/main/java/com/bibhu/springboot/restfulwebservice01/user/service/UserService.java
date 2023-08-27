package com.bibhu.springboot.restfulwebservice01.user.service;

import com.bibhu.springboot.restfulwebservice01.user.model.User;
import com.bibhu.springboot.restfulwebservice01.user.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findByUserId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserBy(Long id) {
        userRepository.deleteById(id);
    }
}
