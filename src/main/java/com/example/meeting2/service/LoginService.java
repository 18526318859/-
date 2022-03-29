package com.example.meeting2.service;

import com.example.meeting2.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoginService {
    public List<User> login(User user);
}
