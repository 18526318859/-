package com.example.meeting2.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BOOK {
    //会议ID
    private Integer meetingid;
    //预订人
    private String lastName;
    //会议名称
    private String meetingname;
    //房间号
    private Integer roomid;
    //开始时间
    private Date starttime;
    //结束时间
    private Date endtime;
    //预约时间
    private Date reservationtime;
}
