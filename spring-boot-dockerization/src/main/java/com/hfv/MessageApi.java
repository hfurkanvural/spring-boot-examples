package com.hfv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @GetMapping
    public String sendMessage(){
        return "Hello World from Container!!!";
    }
}
