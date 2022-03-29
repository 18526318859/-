package com.example.meeting2.service.Impl;

import com.example.meeting2.dao.LoginDao;
import com.example.meeting2.pojo.User;
import com.example.meeting2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class loginserviceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;
    @Override
    public List<User> login(User user) {
        List <User> login = loginDao.login ( user );
        return login;
    }
}
