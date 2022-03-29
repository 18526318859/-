package com.example.meeting2.service;


import com.example.meeting2.dao.meeting;
import com.example.meeting2.pojo.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class meetingService {
    @Autowired
    public meeting meetingdao;
    public int join(Integer employeeid,Integer meetingid){
        return  meetingdao.join (meetingid ,employeeid );
    }

    public List<Integer>  getAllBymeetingid(Integer meetingid)
    {
        List <Integer> allBymeetingid = meetingdao.getAllBymeetingid ( meetingid );
        return  allBymeetingid;
    }

    public MeetingRoom searchBymeetingid(Integer meetingid)
    {
        return meetingdao.searchBymeetingid ( meetingid );
    }
}
