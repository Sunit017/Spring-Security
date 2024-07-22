package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoSecurityController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String User()
    {
        return "User";
    }

    @GetMapping("/admin")
    public String admin()
    {
        return "admin";
    }

}
