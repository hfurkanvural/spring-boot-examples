package main.java.com.demo.simplespringboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/hello")
public class helloApi {
    @GetMapping
    public String hello(){
        return "Hello World!";
    }
}