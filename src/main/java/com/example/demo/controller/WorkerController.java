package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.WorkerMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WorkerController {
    @Autowired
    private WorkerMapper workerMapper;
    @GetMapping("/queryWorkerList")
    public String queryUserList(Model model){
        List<Worker> workerList = workerMapper.queryWorkerList();
        model.addAttribute("workers", workerList);
        return "tables";
    }

    @GetMapping("/addWorker")
    public String toAddpage(){
        return "add";
    }

    @PostMapping("/addWorker")
    public String addPage(Worker worker){
        System.out.println(worker);
        workerMapper.addWorker(worker);
        return "redirect:/queryWorkerList";
    }


}
