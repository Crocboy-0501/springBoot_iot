package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/queryUserList")
    public String queryUserList(Model model){
        List<User> userList = userMapper.queryUserList();
        model.addAttribute("emps", userList);
        return "tableUsers";
    }



    @PostMapping("/addUser")
    public String addPage(User user){
        System.out.println(user);
        userMapper.addUser(user);
        return "redirect:/queryUserList";
    }

    @GetMapping("/addUser")
    public String toAddpage(){
        return "addUser";
    }

//    @ResponseBody
//    @GetMapping("/updateUser")
//    public String updateUser(){
//        userMapper.updateUser(new User(2, "xiaowang", "5678"));
//        return "ok";
//    }


    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userMapper.deleteUser(id);
        return "redirect:/queryUserList";
    }

}
