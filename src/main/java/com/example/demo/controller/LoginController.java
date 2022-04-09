package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/user/login")

    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        User user = userMapper.queryUserByName(userName);
        if(user == null){
            //告诉用户用户名或密码错误
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }else if(user.getName().equals(userName)&&user.getPsw().equals(password)){
            session.setAttribute("loginUser", userName);
            //重定向
            return "redirect:/main.html";
        }else{
            //告诉用户用户名或密码错误
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }

    }
}
