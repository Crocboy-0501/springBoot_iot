package com.example.demo.controller;

import com.example.demo.mapper.ImplementMapper;
import com.example.demo.pojo.Implements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ImplementController {
    @Autowired
    private ImplementMapper implementMapper;


    @GetMapping("/queryImpList")
    public String queryUserList(Model model){
        List<Implements> implementsList = implementMapper.queryImplementList();
        model.addAttribute("Imps", implementsList);

        return "Implement";
//        return "redirect:/Implement.html";
    }
}
