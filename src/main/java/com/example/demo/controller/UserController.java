package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public String queryUserList(Model model){
        List<User> userList = userMapper.queryUserList();
        model.addAttribute("emps", userList);
        return "tables";
    }

    @ResponseBody
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(2, "xiaoming", "1234"));
        return "ok";
    }

    @ResponseBody
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(2, "xiaowang", "5678"));
        return "ok";
    }

    @ResponseBody
    @GetMapping("/deleteUser")
    public String deleteUser(){
        userMapper.deleteUser(2);
        return "ok";
    }

}
