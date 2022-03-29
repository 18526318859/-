package com.example.meeting2.dao;


import com.example.meeting2.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LoginDao {
    public List<User> login(User user);
}
