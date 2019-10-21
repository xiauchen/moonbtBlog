package com.moon.blog.service;

import com.moon.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService{
    User checkUser(String username, String password);
}
