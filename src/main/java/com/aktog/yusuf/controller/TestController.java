package com.aktog.yusuf.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String authenticationTest(){
        return "only available if authenticated";
    }
}
