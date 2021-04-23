package com.webproject.backend.service;

import com.webproject.backend.entity.User;
import com.webproject.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthService {

    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserMapper userMapper,PasswordEncoder passwordEncoder){
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean register(String username,String password){
        userMapper.insertUser(username,passwordEncoder.encode(password));
        return true;
    }

    public User login(String username,String password){
        List<User> users = userMapper.getUser(username);
        for(User user : users){
            if(passwordEncoder.matches(password,user.getPassword()))
                return user;
        }
        return null;
    }
}
