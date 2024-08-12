package com.example.springsecurityex.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/")
    public String hello(HttpServletRequest request)
    {
        return "Welcome" +request.getSession().getId();
    }
    @GetMapping("/add")
    public int add()
    {
        return 3+5;
    }

}
