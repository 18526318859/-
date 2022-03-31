package com.example.meeting2.controller;
import com.example.meeting2.pojo.User;
import com.example.meeting2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class loginController {
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/tomenu")
    public String menu( User user ,HttpSession session,Model model)
    {
        System.out.println ( user );
        session.setAttribute ( "username",user.getUsername () );
        return "menu";
    }
    @RequestMapping("/logout")
    public String logout()
    {
        return "index";
    }


    /*@Autowired
    LoginService loginservice;
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session)
    {
        List <User> login = loginservice.login ( user );
        session.setAttribute ( "loginname",login.get ( 0 ).getUsername () );
        System.out.println ( login.get ( 0 ) );
        if(login.isEmpty ())
       {
           return "redirect:/index";
       }
       else
           return "menu";
    }*/
}
