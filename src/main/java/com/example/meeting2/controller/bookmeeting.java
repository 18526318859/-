package com.example.meeting2.controller;


import com.example.meeting2.pojo.BOOK;
import com.example.meeting2.pojo.MeetingRoom;
import com.example.meeting2.service.bookService;
import com.example.meeting2.service.meetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class bookmeeting {
    @Autowired
    public meetingRoomService roomService;
    public bookService books;
    @RequestMapping("/book")
    public String tobook(Model model, HttpSession Session){
        List<MeetingRoom> getall = roomService.getall ( );
        model.addAttribute ( "rooms",getall );
        return "meetingroom/bookmeeting";
    }
    @RequestMapping("/bookm")
    public String bookm()
    {
        return "meetingroom/bookmeeting";
    }
    @RequestMapping("/bookmeet")
    public String book( BOOK book){

        book.setRoomid ( 5 );
        book.setReservationtime (new Date ());
        System.out.println ( book );
        int re = books.bookm ( book );
        System.out.println ( re );
        return null;
    }


}
