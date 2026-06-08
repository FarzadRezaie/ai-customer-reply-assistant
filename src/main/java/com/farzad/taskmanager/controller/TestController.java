package com.farzad.taskmanager.controller;

import com.farzad.taskmanager.service.ReplyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public  class TestController{

    private final ReplyService replyService;

    public TestController(ReplyService replyService){
        this.replyService = replyService;
    }
    
    @GetMapping("/test-key")
    public String testKey(){
        return replyService.testKey();
    }

    @GetMapping("/reply")
    public String reply(@RequestParam String message){
        return replyService.generateReply(message);
    }
}