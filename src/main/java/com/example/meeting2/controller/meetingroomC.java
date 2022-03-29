package com.example.meeting2.controller;


import com.example.meeting2.pojo.MeetingRoom;
import com.example.meeting2.service.meetingRoomService;
import com.example.meeting2.service.meetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class meetingroomC {
    @Autowired
    public meetingService meetService;
    @Autowired
    public meetingRoomService roomService;
    @RequestMapping("/menu")
    public String getmenu(){
        return "menu";
    }
    @RequestMapping("/meetingrooms")
    public String getall(Model model){
        List <MeetingRoom> getall = roomService.getall ( );
        model.addAttribute ( "rooms",getall );
        return "meetingroom/list";
    }
    @RequestMapping("/room/{id}")
    public String joinroom(Model model, @PathVariable("id") int id)
    {
        model.addAttribute ( "roomid",id );
        return "meetingroom/input";
    }
    @RequestMapping("/room/join")
    @ResponseBody
    public  int join(@RequestParam("userid") String userid, String password, @RequestParam("roomid") String roomid){
        Integer id = new Integer ( userid );
        Integer pass = new Integer ( password );
        Integer rid = new Integer ( roomid );
        if (userid !=null &&"123456".equals ( password ))
        {
            int join = meetService.join ( rid, id );
            return join;
        }
        return  0;

    }
    @RequestMapping("/meetingnum")
    public String showmeeting()
    {
        return "meetingroom/inputid";
    }
    @RequestMapping("/room/meetid")
    public String getAllBymeetingid(@RequestParam("roomid") String meetingid, Model model){
        Integer id = new Integer ( meetingid );
        System.out.println ( meetingid );
        List <Integer> allBymeetingid = meetService.getAllBymeetingid ( id );
        model.addAttribute ( "roomid",id.intValue () );
        model.addAttribute ( "listid" ,allBymeetingid);
        return  "meetingroom/listid";

    }

    @RequestMapping("/searchmeetings")
    public String searchmeeting()
    {
        return "meetingroom/inputmeetid";
    }

    @RequestMapping("/meet/meetid")
    public String search(Model model, @RequestParam("roomid") String meetingid){
        Integer id = new Integer ( meetingid );
        MeetingRoom room = meetService.searchBymeetingid ( id );
        model.addAttribute ( "rooms",room );
        return "meetingroom/list";
    }

    @RequestMapping("/addmeetingroom")
    public String addroom(){
        return "meetingroom/add";
    }

    @RequestMapping("/AddMr")
    public String doAddMr(MeetingRoom meetingRoom) {
        Integer result = roomService.addMr(meetingRoom);
        return "redirect:/meetingrooms";
    }
}
