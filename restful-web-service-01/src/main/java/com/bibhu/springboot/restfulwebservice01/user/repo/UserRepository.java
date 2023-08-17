package com.bibhu.springboot.restfulwebservice01.user.repo;

import com.bibhu.springboot.restfulwebservice01.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
