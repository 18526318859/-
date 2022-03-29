package com.example.meeting2.service;


import com.example.meeting2.dao.meetingRoomDao;
import com.example.meeting2.pojo.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class meetingRoomService {
    @Autowired
    public meetingRoomDao roomDao;
    public List<MeetingRoom> getall() {
        return roomDao.getall();
    }
    public Integer addMr(MeetingRoom meetingRoom) {
        return roomDao.addMr ( meetingRoom );
    }
}
