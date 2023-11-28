package com.aktog.yusuf.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String authenticationTest(){
        return "only available if admin";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public String authenticationTest2(){
        return "only available if user";
    }


}
