package com.example.meeting2.dao;


import com.example.meeting2.pojo.BOOK;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookDao {
    public Integer bookm(BOOK book);
}
