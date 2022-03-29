package com.example.meeting2.service;


import com.example.meeting2.dao.BookDao;
import com.example.meeting2.pojo.BOOK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class bookService {
    @Autowired
    public BookDao bookdao;
    public Integer bookm(BOOK book)
    {
        return bookdao.bookm ( book );
    }
}
